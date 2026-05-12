import java.util.*;

/**
 * Valid Palindrome
 *
 * Approaches:
 * 1. String Cleanup + Two Pointers
 * 2. Optimized Two Pointers (Without Extra String)
 */
public class ValidPalindrome {

    // ---------------------------------------------------
    // Approach 1: Cleanup String + Two Pointers
    // Time: O(n)
    // Space: O(n)
    // ---------------------------------------------------
    public static boolean isPalindromeUsingExtraSpace(String s) {

        char[] chars = s
                .trim()
                .replaceAll("[^0-9A-Za-z]", "")
                .toLowerCase()
                .toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left <= right) {

            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // ---------------------------------------------------
    // Approach 2: Optimized Two Pointers
    // Time: O(n)
    // Space: O(1)
    // ---------------------------------------------------
    public static boolean isPalindromeOptimized(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // ---------------------------------------------------
    // Test Cases
    // ---------------------------------------------------
    public static void main(String[] args) {

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";
        String s4 = "Madam";
        String s5 = "No lemon, no melon";

        System.out.println("Using Extra Space");
        System.out.println(isPalindromeUsingExtraSpace(s1));
        System.out.println(isPalindromeUsingExtraSpace(s2));
        System.out.println(isPalindromeUsingExtraSpace(s3));
        System.out.println(isPalindromeUsingExtraSpace(s4));
        System.out.println(isPalindromeUsingExtraSpace(s5));

        System.out.println();

        System.out.println("Optimized Approach");
        System.out.println(isPalindromeOptimized(s1));
        System.out.println(isPalindromeOptimized(s2));
        System.out.println(isPalindromeOptimized(s3));
        System.out.println(isPalindromeOptimized(s4));
        System.out.println(isPalindromeOptimized(s5));
    }
}
