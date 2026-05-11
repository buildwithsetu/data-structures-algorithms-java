public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    // ---------------------------------------------------------
    // Valid Anagram
    // Time: O(n)
    // Space: O(1)
    // Count character frequency using array
    // ---------------------------------------------------------
    public static boolean isAnagram(String s, String t) {

        // Different length -> cannot be anagram
        if (s.length() != t.length()) {
            return false;
        }

        // Convert string to char array
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        // Frequency array for a-z
        int[] sOcc = new int[26];
        int[] tOcc = new int[26];

        // Count occurrences
        for (int i = 0; i < s.length(); i++) {

            sOcc[sChar[i] - 'a']++;
            tOcc[tChar[i] - 'a']++;
        }

        // Compare frequency arrays
        for (int j = 0; j < 26; j++) {

            // Mismatch found
            if (sOcc[j] != tOcc[j]) {
                return false;
            }
        }

        // All counts matched
        return true;
    }
}
