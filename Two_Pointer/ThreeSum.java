import java.util.*;

/**
 * 3Sum
 *
 * Approaches:
 * 1. Sorting + Two Pointers
 * 2. HashSet Based
 */
public class ThreeSum {

    // ---------------------------------------------------
    // Approach 1: Sorting + Two Pointers
    // Time: O(n^2)
    // Space: O(1) excluding output
    // ---------------------------------------------------
    public static List<List<Integer>> threeSumTwoPointers(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {

                    right--;

                } else if (sum < 0) {

                    left++;

                } else {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    // ---------------------------------------------------
    // Approach 2: HashSet
    // Time: O(n^2)
    // Space: O(n)
    // ---------------------------------------------------
    public static List<List<Integer>> threeSumHashSet(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                int complement = -(nums[i] + nums[j]);

                if (seen.contains(complement)) {

                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);

                    Collections.sort(triplet);

                    result.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }

    // ---------------------------------------------------
    // Test Cases
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums1 = {-1, 0, 1, 2, -1, -4};

        int[] nums2 = {0, 1, 1};

        int[] nums3 = {0, 0, 0};

        int[] nums4 = {-2, 0, 1, 1, 2};

        System.out.println("Two Pointers Approach");
        System.out.println(threeSumTwoPointers(nums1));
        System.out.println(threeSumTwoPointers(nums2));
        System.out.println(threeSumTwoPointers(nums3));
        System.out.println(threeSumTwoPointers(nums4));

        System.out.println();

        System.out.println("HashSet Approach");
        System.out.println(threeSumHashSet(nums1));
        System.out.println(threeSumHashSet(nums2));
        System.out.println(threeSumHashSet(nums3));
        System.out.println(threeSumHashSet(nums4));
    }
}
