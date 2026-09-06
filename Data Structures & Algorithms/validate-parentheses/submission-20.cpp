class Solution {
public:
    bool isValid(const string& input) {
        char stack[1000];
        char* top = stack;

        const char* data = input.data();
        const size_t length = input.size();

        bool result;

        asm volatile(
            // rcx = input index
            // rdx = stack pointer
            // r8  = current character
            // r9  = popped character

            "xor %%rcx, %%rcx\n\t"
            "xor %%rdx, %%rdx\n\t"

            // =========================================================
            // Main loop
            // =========================================================
            "loop_start:\n\t"

            "cmp %[length], %%rcx\n\t"
            "jae loop_done\n\t"

            // Load current character
            "movzbl (%[data], %%rcx, 1), %%r8d\n\t"
            "inc %%rcx\n\t"

            // =========================================================
            // Opening brackets
            //
            // '(' = 40
            // '[' = 91
            // '{' = 123
            // =========================================================

            "cmp $40, %%r8b\n\t"
            "je push_bracket\n\t"

            "cmp $91, %%r8b\n\t"
            "je push_bracket\n\t"

            "cmp $123, %%r8b\n\t"
            "je push_bracket\n\t"

            // =========================================================
            // Closing bracket
            // =========================================================

            // Stack empty?
            "test %%rdx, %%rdx\n\t"
            "jz invalid\n\t"

            // Pop
            "dec %%rdx\n\t"
            "movzbl (%[stack], %%rdx, 1), %%r9d\n\t"

            // =========================================================
            // ')' = 41, expected '(' = 40
            // =========================================================

            "cmp $41, %%r8b\n\t"
            "jne check_square\n\t"

            "cmp $40, %%r9b\n\t"
            "jne invalid\n\t"

            "jmp loop_start\n\t"

            // =========================================================
            // ']' = 93, expected '[' = 91
            // =========================================================

            "check_square:\n\t"

            "cmp $93, %%r8b\n\t"
            "jne check_curly\n\t"

            "cmp $91, %%r9b\n\t"
            "jne invalid\n\t"

            "jmp loop_start\n\t"

            // =========================================================
            // '}' = 125, expected '{' = 123
            // =========================================================

            "check_curly:\n\t"

            "cmp $125, %%r8b\n\t"
            "jne invalid\n\t"

            "cmp $123, %%r9b\n\t"
            "jne invalid\n\t"

            "jmp loop_start\n\t"

            // =========================================================
            // Push
            // =========================================================

            "push_bracket:\n\t"

            "movb %%r8b, (%[stack], %%rdx, 1)\n\t"
            "inc %%rdx\n\t"

            "jmp loop_start\n\t"

            // =========================================================
            // Successful completion
            // =========================================================

            "loop_done:\n\t"

            "test %%rdx, %%rdx\n\t"
            "setz %%al\n\t"
            "movzbl %%al, %%eax\n\t"

            "jmp finished\n\t"

            // =========================================================
            // Invalid
            // =========================================================

            "invalid:\n\t"

            "xor %%eax, %%eax\n\t"

            // =========================================================
            // Return
            // =========================================================

            "finished:\n\t"

            : "=a"(result)

            : [data]   "r"(data),
              [length] "r"(length),
              [stack]  "r"(stack)

            : "rcx",
              "rdx",
              "r8",
              "r9",
              "memory",
              "cc"
        );

        return result;
    }
};