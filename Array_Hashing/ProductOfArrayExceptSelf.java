import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] ans = productExceptSelf(nums);

        System.out.println(Arrays.toString(ans));
    }

    // ---------------------------------------------------------
    // Product of Array Except Self
    // Time: O(n)
    // Space: O(n)
    // Prefix Product + Suffix Product
    // ---------------------------------------------------------
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // Stores product of left side elements
        int[] leftProduct = new int[n];

        // Stores product of right side elements
        int[] rightProduct = new int[n];

        // Final answer array
        int[] ans = new int[n];

        // First element has no left side
        leftProduct[0] = 1;

        // Last element has no right side
        rightProduct[n - 1] = 1;

        // -----------------------------------------------------
        // Build Left Prefix Product
        // leftProduct[i] =
        // product of all elements before i
        // -----------------------------------------------------
        for (int i = 1; i < n; i++) {

            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        // -----------------------------------------------------
        // Build Right Suffix Product
        // rightProduct[j] =
        // product of all elements after j
        // -----------------------------------------------------
        for (int j = n - 2; j >= 0; j--) {

            rightProduct[j] = rightProduct[j + 1] * nums[j + 1];
        }

        // -----------------------------------------------------
        // Final Answer
        // Multiply left and right products
        // -----------------------------------------------------
        for (int k = 0; k < n; k++) {

            ans[k] = leftProduct[k] * rightProduct[k];
        }

        return ans;
    }
}
