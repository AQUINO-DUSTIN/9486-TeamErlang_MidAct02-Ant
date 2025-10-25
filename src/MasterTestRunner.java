import DelaCruz_Mabalot.E14_LongestCommonPrefix.LongestCommonPrefix;
import DelaCruz_Mabalot.E26_RemoveDuplicatesFromSortedArray.RemoveDuplicatesFromSortedArray;
import DelaCruz_Mabalot.E28_FindTheIndexOfTheFirstOccurrenceInAString.FindTheIndexOfTheFirstOccurrenceInAString;
import DelaCruz_Mabalot.H4_MedianOfTwoSortedArrays.MedianOfTwoSortedArrays;
import DelaCruz_Mabalot.M2_AddTwoNumbers.AddTwoNumbers;
import DelaCruz_Mabalot.M3_LongestSubstringWithoutRepeatingCharacters.LongestSubstringWithoutRepeatingCharacters;

public class MasterTestRunner {

    public static void main(String[] args) {
        System.out.println("\n==========================================================================");
        System.out.println("                   STARTING FULL LEETCODE SOLUTION TEST SUITE              ");
        System.out.println("==========================================================================");

        try {
            System.out.println("\n----- RUNNING TEST DIRECTORY: DelaCruz_Mabalot -----");

            System.out.println("\n--- RUNNING TEST SUITE: Longest Common Prefix (Easy - 14) ---");
            LongestCommonPrefix.main(new String[]{});

            System.out.println("\n==========================================================================");

            System.out.println("\n--- RUNNING TEST SUITE: Remove Duplicates from Sorted Array (Easy - 26) ---");
            RemoveDuplicatesFromSortedArray.main(new String[]{});

            System.out.println("\n==========================================================================");

            System.out.println("\n--- RUNNING TEST SUITE: Find Index of First Occurrence in a String (Easy - 28) ---");
            FindTheIndexOfTheFirstOccurrenceInAString.main(new String[]{});

            System.out.println("\n==========================================================================");

            System.out.println("\n--- RUNNING TEST SUITE: Add Two Numbers (M - 2) ---");
            AddTwoNumbers.main(new String[]{});

            System.out.println("\n--- RUNNING TEST SUITE: Longest Substring Without Repeating Characters (Medium - 3) ---");
            LongestSubstringWithoutRepeatingCharacters.main(new String[]{});

            System.out.println("\n--- RUNNING TEST SUITE: Median of Two Sorted Arrays (Hard - 4) ---");
            MedianOfTwoSortedArrays.main(new String[]{});

            // add other classes.main() here

        } catch (Exception e) {
            System.err.println("\nFATAL ERROR DURING TEST EXECUTION:");
            System.err.println("A test suite failed to run or encountered an error. Check the compilation logs.");
            e.printStackTrace();
        }

        System.out.println("\n==========================================================================");
        System.out.println("                         FULL TEST SUITE FINISHED                          ");
        System.out.println("==========================================================================");
    }
}