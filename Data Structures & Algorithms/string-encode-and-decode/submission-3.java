class Solution {

    public String encode(List<String> strs) {
        java.lang.StringBuilder encoded = new java.lang.StringBuilder();

        encoded.append(String.format("%03d", strs.size()));

        for (String str : strs) {
            encoded.append(String.format("%03d", str.length()));
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) throws IOException {
        char[] buff;

        List<String> decodedStrings = new LinkedList<>();

        try (
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.StringReader(str));
        ) {
            buff = new char[3];
            reader.read(buff, 0, 3);

            int numberOfStrings = Integer.parseInt(new String(buff));

            for (int i=0;i<numberOfStrings;i++) {
                buff = new char[3];
                reader.read(buff, 0, 3);

                int stringLength = Integer.parseInt(new String(buff));

                buff = new char[stringLength];
                reader.read(buff, 0, stringLength);

                decodedStrings.add(new String(buff));
            }
        }

        return decodedStrings;
    }
}
