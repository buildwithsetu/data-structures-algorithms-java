import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(nums));
    }

    // ---------------------------------------------------------
    // Longest Consecutive Sequence
    // Time: O(n)
    // Space: O(n)
    // Start counting only from sequence starting point
    // ---------------------------------------------------------
    public static int longestConsecutive(int[] nums) {

        // Empty array
        if (nums.length == 0) {
            return 0;
        }

        // Store unique elements
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            set.add(num);
        }

        int maxCount = 0;

        for (int num : set) {

            // Sequence starting point
            // No previous consecutive element
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count consecutive sequence
                while (set.contains(currentNum + 1)) {

                    currentNum++;
                    count++;
                }

                // Update maximum length
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
