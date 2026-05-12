import java.util.*;

/**
 * Top K Frequent Elements
 *
 * Approaches:
 * 1. Bucket Sort  -> O(n)
 * 2. Sorting      -> O(n log n)
 */
public class TopKFrequentElements {

    // ---------------------------------------------------
    // Approach 1: Bucket Sort
    // Time: O(n)
    // Space: O(n)
    // ---------------------------------------------------
    public static int[] topKFrequentBucket(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int frequency = entry.getValue();
            int value = entry.getKey();

            bucket[frequency].add(value);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {

            for (int value : bucket[i]) {

                result[index++] = value;

                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }

    // ---------------------------------------------------
    // Approach 2: Sorting
    // Time: O(n log n)
    // Space: O(n)
    // ---------------------------------------------------
    public static int[] topKFrequentSorting(int[] nums, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(frequencyMap.keySet());

        values.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = values.get(i);
        }

        return result;
    }

    // ---------------------------------------------------
    // Test Cases
    // ---------------------------------------------------
    public static void main(String[] args) {

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;

        int[] nums2 = {1};
        int k2 = 1;

        int[] nums3 = {4, 4, 4, 6, 6, 7, 7, 7, 7};
        int k3 = 2;

        System.out.println("Bucket Sort Approach");
        System.out.println(Arrays.toString(topKFrequentBucket(nums1, k1)));
        System.out.println(Arrays.toString(topKFrequentBucket(nums2, k2)));
        System.out.println(Arrays.toString(topKFrequentBucket(nums3, k3)));

        System.out.println();

        System.out.println("Sorting Approach");
        System.out.println(Arrays.toString(topKFrequentSorting(nums1, k1)));
        System.out.println(Arrays.toString(topKFrequentSorting(nums2, k2)));
        System.out.println(Arrays.toString(topKFrequentSorting(nums3, k3)));
    }
}
