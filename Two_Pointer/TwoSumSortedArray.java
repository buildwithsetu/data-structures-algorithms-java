import java.util.*;

/**
 * Two Sum II - Input Array Is Sorted
 *
 * Approaches:
 * 1. Two Pointers
 * 2. HashMap
 */
public class TwoSumSortedArray {

    // ---------------------------------------------------
    // Approach 1: Two Pointers
    // Time: O(n)
    // Space: O(1)
    // ---------------------------------------------------
    public static int[] twoSumTwoPointers(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }

    // ---------------------------------------------------
    // Approach 2: HashMap
    // Time: O(n)
    // Space: O(n)
    // ---------------------------------------------------
    public static int[] twoSumHashMap(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            int complement = target - numbers[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1};
            }

            map.put(numbers[i], i);
        }

        return new int[]{-1, -1};
    }

    // ---------------------------------------------------
    // Test Cases
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {2, 3, 4};
        int target2 = 6;

        int[] nums3 = {-1, 0};
        int target3 = -1;

        int[] nums4 = {1, 2, 3, 4, 6};
        int target4 = 10;

        System.out.println("Two Pointers Approach");
        System.out.println(Arrays.toString(twoSumTwoPointers(nums1, target1)));
        System.out.println(Arrays.toString(twoSumTwoPointers(nums2, target2)));
        System.out.println(Arrays.toString(twoSumTwoPointers(nums3, target3)));
        System.out.println(Arrays.toString(twoSumTwoPointers(nums4, target4)));

        System.out.println();

        System.out.println("HashMap Approach");
        System.out.println(Arrays.toString(twoSumHashMap(nums1, target1)));
        System.out.println(Arrays.toString(twoSumHashMap(nums2, target2)));
        System.out.println(Arrays.toString(twoSumHashMap(nums3, target3)));
        System.out.println(Arrays.toString(twoSumHashMap(nums4, target4)));
    }
}
