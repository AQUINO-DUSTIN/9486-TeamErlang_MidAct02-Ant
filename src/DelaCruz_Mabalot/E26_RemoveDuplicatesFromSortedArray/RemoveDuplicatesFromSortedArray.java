package DelaCruz_Mabalot.E26_RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solver = new RemoveDuplicatesFromSortedArray();

        int[][] testInputs = {
                {1, 1, 2},
                {0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                {}
        };
        int[] expectedLengths = {2, 5, 0};

        System.out.println("\n--- Remove Duplicates from Sorted Array Tests ---");

        System.out.printf("%-35s | %-10s | %-10s | %-10s\n",
                "Input Array", "Expected", "Actual", "Result");
        System.out.println("----------------------------------------------------------------------");

        // Iterate through all test cases
        for (int i = 0; i < testInputs.length; i++) {
            int[] nums = testInputs[i].clone();
            String inputStr = Arrays.toString(testInputs[i]);

            int expected = expectedLengths[i];
            int actual_k = solver.removeDuplicates(nums); // Runs your logic

            String resultStatus = (actual_k == expected) ? "PASS" : "FAIL";

            System.out.printf("%-35s | %-10d | %-10d | %-10s\n",
                    inputStr, expected, actual_k, resultStatus);
        }

        System.out.println("----------------------------------------------------------------------\n");
    }

    /**
     * Removes duplicates from a sorted integer array in place. The method uses the array's sorted property to determine
     * unique elements. The first 'k' elements of the input array will contain the unique elements.
     *
     * @param nums The input array of integers, which is assumed to be sorted.
     * @return The number of unique elements (k) in the array.
     * @author Dela Cruz, Angelika
     * @author Mabalot, Rod Clarenz
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 0;
        int largest = nums[nums.length - 1];

        for (int i = nums[0]; i <= largest; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    nums[k] = i;
                    k++;
                    break;
                }
            }
        }
        return k;
    }
}
