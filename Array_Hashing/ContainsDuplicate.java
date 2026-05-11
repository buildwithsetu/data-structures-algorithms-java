import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println(containsDuplicateBruteForce(nums));
        System.out.println(containsDuplicateBetter(nums));
        System.out.println(containsDuplicateOptimal(nums));
    }

    // ---------------------------------------------------------
    // 1. Brute Force
    // Time: O(n^2)
    // Space: O(1)
    // Compare every element with every other element
    // ---------------------------------------------------------
    public static boolean containsDuplicateBruteForce(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                // Duplicate found
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // ---------------------------------------------------------
    // 2. Better Approach - Sorting
    // Time: O(n log n)
    // Space: Depends on sorting implementation
    // Sort array -> compare adjacent elements
    // ---------------------------------------------------------
    public static boolean containsDuplicateBetter(int[] nums) {

        // Sorting modifies original array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            // Adjacent duplicate after sorting
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    // ---------------------------------------------------------
    // 3. Optimal Approach - HashSet
    // Time: O(n)
    // Space: O(n)
    // HashSet stores unique elements only
    // ---------------------------------------------------------
    public static boolean containsDuplicateOptimal(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            // If already exists -> duplicate
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
