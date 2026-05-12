import java.util.*;

/**
 * Container With Most Water
 *
 * Approaches:
 * 1. Two Pointers
 * 2. Brute Force
 */
public class ContainerWithMostWater {

    // ---------------------------------------------------
    // Approach 1: Two Pointers
    // Time: O(n)
    // Space: O(1)
    // ---------------------------------------------------
    public static int maxAreaTwoPointers(int[] heights) {

        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while (left < right) {

            int height = Math.min(heights[left], heights[right]);

            int width = right - left;

            int area = height * width;

            maxArea = Math.max(maxArea, area);

            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }

    // ---------------------------------------------------
    // Approach 2: Brute Force
    // Time: O(n^2)
    // Space: O(1)
    // ---------------------------------------------------
    public static int maxAreaBruteForce(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            for (int j = i + 1; j < heights.length; j++) {

                int height = Math.min(heights[i], heights[j]);

                int width = j - i;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // ---------------------------------------------------
    // Test Cases
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int[] heights2 = {1, 1};

        int[] heights3 = {4, 3, 2, 1, 4};

        int[] heights4 = {1, 2, 1};

        System.out.println("Two Pointers Approach");
        System.out.println(maxAreaTwoPointers(heights1));
        System.out.println(maxAreaTwoPointers(heights2));
        System.out.println(maxAreaTwoPointers(heights3));
        System.out.println(maxAreaTwoPointers(heights4));

        System.out.println();

        System.out.println("Brute Force Approach");
        System.out.println(maxAreaBruteForce(heights1));
        System.out.println(maxAreaBruteForce(heights2));
        System.out.println(maxAreaBruteForce(heights3));
        System.out.println(maxAreaBruteForce(heights4));
    }
}
