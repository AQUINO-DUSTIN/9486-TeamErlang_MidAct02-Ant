package DelaCruz_Mabalot.H4_MedianOfTwoSortedArrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();

        int[][] nums1Inputs = {
                {1, 3},
                {1, 2}
        };
        int[][] nums2Inputs = {
                {2},
                {3, 4}
        };

        double[] expectedResults = {2.0, 2.5};

        System.out.println("\n--- Median of Two Sorted Arrays Tests ---");

        System.out.printf("%-20s | %-20s | %-10s | %-10s | %-10s\n",
                "Input (nums1)", "Input (nums2)", "Expected", "Actual", "Result");
        System.out.println("------------------------------------------------------------------------------");

        for (int i = 0; i < nums1Inputs.length; i++) {
            int[] nums1 = nums1Inputs[i];
            int[] nums2 = nums2Inputs[i];

            double expected = expectedResults[i];
            double actual = solver.findMedianSortedArrays(nums1, nums2);

            boolean passed = Math.abs(actual - expected) < 1e-9;
            String resultStatus = passed ? "PASS" : "FAIL";

            String inputStr1 = Arrays.toString(nums1);
            String inputStr2 = Arrays.toString(nums2);

            System.out.printf("%-20s | %-20s | %-10.1f | %-10.1f | %-10s\n",
                    inputStr1, inputStr2, expected, actual, resultStatus);
        }

        System.out.println("------------------------------------------------------------------------------\n");
    }

    /**
     * Finds the median of two sorted arrays, `nums1` and `nums2`, using a binary search approach to achieve
     * O(log(min(m, n))) time complexity, where m and n are the lengths of the arrays. The method ensures the smaller
     * array is always used for binary searching for efficiency.
     *
     * @param nums1 The first sorted integer array.
     * @param nums2 The second sorted integer array.
     * @return The median of the two combined sorted arrays as a double.
     * @throws IllegalArgumentException if the input arrays are not sorted (though typical LeetCode
     * implementation assumes they are).
     * @author Dela Cruz, Angelika
     * @author Mabalot, Rod Clarenz
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2;
        int left = 0, right = m;

        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = totalLeft - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
