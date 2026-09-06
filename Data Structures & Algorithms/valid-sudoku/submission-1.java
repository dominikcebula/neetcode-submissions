class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
        }

        Set<Character>[][] squares = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new HashSet<Character>();
            }
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];

                if (ch == '.')
                    continue;

                if (rows[row].contains(ch))
                    return false;
                if (cols[col].contains(ch))
                    return false;
                if (squares[row / 3][col / 3].contains(ch))
                    return false;

                rows[row].add(ch);
                cols[col].add(ch);
                squares[row / 3][col / 3].add(ch);
            }
        }

        return true;
    }
}
