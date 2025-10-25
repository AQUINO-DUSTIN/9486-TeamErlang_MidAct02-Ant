package DelaCruz_Mabalot.E28_FindTheIndexOfTheFirstOccurrenceInAString;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString solver = new FindTheIndexOfTheFirstOccurrenceInAString();

        String[][] testInputs = {
                {"sadbutsad", "sad"},
                {"leetcode", "leeto"},
                {"mississippi", "issip"}
        };
        int[] expectedResults = {0, -1, 4};

        System.out.println("\n--- Find the Index of the First Occurrence Tests ---");

        System.out.printf("%-30s | %-10s | %-10s | %-10s\n",
                "Input (Haystack, Needle)", "Expected", "Actual", "Result");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < testInputs.length; i++) {
            String haystack = testInputs[i][0];
            String needle = testInputs[i][1];

            int expected = expectedResults[i];
            int actual = solver.strStr(haystack, needle);

            String resultStatus = (actual == expected) ? "PASS" : "FAIL";

            String inputStr = String.format("(\"%s\", \"%s\")", haystack, needle);

            System.out.printf("%-30s | %-10d | %-10d | %-10s\n",
                    inputStr, expected, actual, resultStatus);
        }

        System.out.println("------------------------------------------------------------------\n");
    }

    /**
     * Finds the index of the first occurrence of the `needle` string within the `haystack` string. This implementation
     * uses a simple sliding window and substring comparison.
     *
     * @param haystack The string to be searched within.
     * @param needle The substring to search for.
     * @return The starting index of the first occurrence of `needle` in `haystack`,
     * or -1 if `needle` is not part of `haystack`. Returns 0 if `needle` is empty.
     * @author Dela Cruz, Angelika
     * @author Mabalot, Rod Clarenz
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
