import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {

        List<String> strs = new ArrayList<>();

        strs.add("neet");
        strs.add("code");
        strs.add("love");
        strs.add("you");

        String encoded = encode(strs);

        System.out.println("Encoded: " + encoded);

        List<String> decoded = decode(encoded);

        System.out.println("Decoded: " + decoded);
    }

    // ---------------------------------------------------------
    // Encode and Decode Strings
    // Encode Format:
    // length#string
    // Example:
    // 4#neet4#code
    // ---------------------------------------------------------

    // ---------------------------------------------------------
    // ENCODE
    // Time: O(n)
    // Space: O(n)
    // Store length + delimiter + string
    // ---------------------------------------------------------
    public static String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        // Empty list
        if (strs.isEmpty()) {
            return "";
        }

        for (String str : strs) {

            // Format -> length#string
            sb.append(str.length())
              .append("#")
              .append(str);
        }

        return sb.toString();
    }

    // ---------------------------------------------------------
    // DECODE
    // Time: O(n)
    // Space: O(n)
    // Read length before '#'
    // Extract string using length
    // ---------------------------------------------------------
    public static List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // Find delimiter '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // Extract length
            int length = Integer.parseInt(str.substring(i, j));

            // Move to actual string start
            i = j + 1;

            // End index of current string
            int end = i + length;

            // Extract original string
            ans.add(str.substring(i, end));

            // Move pointer to next encoded string
            i = end;
        }

        return ans;
    }
}
