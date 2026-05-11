import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagramsBruteForce(strs));
        System.out.println(groupAnagramsSorting(strs));
        System.out.println(groupAnagramsFrequency(strs));
    }

    // ---------------------------------------------------------
    // 1. Brute Force - Nested Loop
    // Time: O(n^2 * k log k)
    // Space: O(n)
    // Compare every string with every other string
    // ---------------------------------------------------------
    public static List<List<String>> groupAnagramsBruteForce(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            // Skip already grouped strings
            if (visited[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                // Check anagram
                if (isAnagram(strs[i], strs[j])) {

                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    // Helper method for brute force approach
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    // ---------------------------------------------------------
    // 2. Better Approach - Sorting + HashMap
    // Time: O(n * k log k)
    // Space: O(n)
    // Sorted string used as key
    // ---------------------------------------------------------
    public static List<List<String>> groupAnagramsSorting(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String current = strs[i];

            // Convert to char array
            char[] chars = current.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Create sorted string key
            String sortedStr = new String(chars);

            // Create list if absent
            map.putIfAbsent(sortedStr, new ArrayList<>());

            // Add current string
            map.get(sortedStr).add(current);
        }

        return new ArrayList<>(map.values());
    }

    // ---------------------------------------------------------
    // 3. Optimal - Frequency Array + HashMap
    // Time: O(n * k)
    // Space: O(n)
    // Character frequency used as key
    // ---------------------------------------------------------
    public static List<List<String>> groupAnagramsFrequency(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Frequency array for a-z
            int[] freq = new int[26];

            // Count characters
            for (char ch : str.toCharArray()) {

                freq[ch - 'a']++;
            }

            // Convert frequency array to string key
            String key = Arrays.toString(freq);

            // Create list if absent
            map.putIfAbsent(key, new ArrayList<>());

            // Add string to group
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
