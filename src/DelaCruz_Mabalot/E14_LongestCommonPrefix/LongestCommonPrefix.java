package DelaCruz_Mabalot.E14_LongestCommonPrefix;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix solver = new LongestCommonPrefix();

        String[][] testInputs = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"}
        };
        String[] expectedResults = {"fl", ""};

        System.out.println("\n--- Longest Common Prefix Tests ---");

        System.out.printf("%-25s | %-8s | %-8s | %-5s\n",
                "Input String Array", "Expected", "Actual", "Result");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < testInputs.length; i++) {
            String[] strs = testInputs[i];
            String inputStr = java.util.Arrays.toString(strs);

            String expected = expectedResults[i];
            String actual = solver.longestCommonPrefix(strs);

            String resultStatus = actual.equals(expected) ? "PASS" : "FAIL";

            System.out.printf("%-25s | %-8s | %-8s | %-5s\n",
                    inputStr, expected, actual, resultStatus);
        }

        System.out.println("---------------------------------------------------------\n");
    }

    /**
     * Finds the longest common prefix string amongst an array of strings. The method uses a horizontal scanning
     * approach: it starts with the first string as the prefix and iteratively shortens it until it matches the start
     * of every subsequent string.
     *
     * @param strs The input array of strings.
     * @return The longest common prefix string. Returns an empty string ("")
     * if there is no common prefix or the input array is empty.
     * @author Dela Cruz, Angelika
     * @author Mabalot, Rod Clarenz
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}