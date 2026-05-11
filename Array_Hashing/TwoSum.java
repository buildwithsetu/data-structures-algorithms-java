import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] bruteAns = twoSumBruteForce(nums, target);
        int[] optimalAns = twoSumOptimal(nums, target);

        System.out.println(bruteAns[0] + ", " + bruteAns[1]);
        System.out.println(optimalAns[0] + ", " + optimalAns[1]);
    }

    // ---------------------------------------------------------
    // 1. Brute Force
    // Time: O(n^2)
    // Space: O(1)
    // Check every possible pair
    // ---------------------------------------------------------
    public static int[] twoSumBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                // Pair found
                if (nums[i] + nums[j] == target) {

                    return new int[]{i, j};
                }
            }
        }

        // No valid pair
        return new int[]{-1, -1};
    }

    // ---------------------------------------------------------
    // 2. Optimal - HashMap
    // Time: O(n)
    // Space: O(n)
    // Store number and index in HashMap
    // ---------------------------------------------------------
    public static int[] twoSumOptimal(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // First element added manually
        map.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {

            // Required number
            int rem = target - nums[i];

            // If remainder already exists
            if (map.containsKey(rem)) {

                return new int[]{map.get(rem), i};
            }

            // Store current number and index
            map.put(nums[i], i);
        }

        // No valid pair
        return new int[]{-1, -1};
    }
}
