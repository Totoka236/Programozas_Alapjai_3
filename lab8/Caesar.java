

public class Caesar {

    public Caesar() {}

    // ASCII A->(DEC)65 B->(DEC)90
    public String caesarCode(String input, char offset) {
        
        input = input.toUpperCase();
       

        StringBuilder result = new StringBuilder();
        int shift = offset - 'A'; // 'A' -> 0, 'B' -> 1, stb.

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                // eltolas
                char ch = (char) ((c - 'A' + shift) % 26 + 'A');
                result.append(ch);
            } else {
                // ha nem betu nem valtozik
                result.append(c);
            }
        }

        return result.toString();
    }
           
}
