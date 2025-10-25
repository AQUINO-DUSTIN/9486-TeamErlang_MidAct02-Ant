package DelaCruz_Mabalot.M3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();

        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew"};
        int[] expectedResults = {3, 1, 3};

        System.out.println("\n--- Longest Substring Without Repeating Characters ---");

        System.out.printf("%-12s | %-10s | %-10s | %-5s\n",
                "Input String", "Expected", "Actual", "Result");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i];
            int expected = expectedResults[i];
            int actual = solver.lengthOfLongestSubstring(s);
            String resultStatus = (actual == expected) ? "PASS" : "FAIL";

            // Print table row using printf for precise column alignment
            System.out.printf("%-12s | %-10d | %-10d | %-5s\n",
                    s, expected, actual, resultStatus);
        }
        System.out.println("-----------------------------------------------\n");
    }

    /**
     * Finds the length of the longest substring in the input string without any repeating characters. This uses the
     * sliding window technique to achieve O(N) time complexity.
     *
     * @param s The input string from which to find the longest non-repeating substring.
     * @return The length of the longest substring without character repetition.
     * @author Dela Cruz, Angelika
     * @author Mabalot, Rod Clarenz
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);

            while (seen.contains(current)) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}