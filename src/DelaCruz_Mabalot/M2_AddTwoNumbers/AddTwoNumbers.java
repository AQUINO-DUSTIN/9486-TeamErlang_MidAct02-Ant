package DelaCruz_Mabalot.M2_AddTwoNumbers;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        AddTwoNumbers solver = new AddTwoNumbers();

        List<int[]> nums1List = new ArrayList<>();
        nums1List.add(new int[]{2, 4, 3});
        nums1List.add(new int[]{0});
        nums1List.add(new int[]{9, 9, 9, 9, 9, 9, 9});

        List<int[]> nums2List = new ArrayList<>();
        nums2List.add(new int[]{5, 6, 4});
        nums2List.add(new int[]{0});
        nums2List.add(new int[]{9, 9, 9, 9});

        List<int[]> expectedArrayList = new ArrayList<>();
        expectedArrayList.add(new int[]{7, 0, 8});
        expectedArrayList.add(new int[]{0});
        expectedArrayList.add(new int[]{8, 9, 9, 9, 0, 0, 0, 1});


        System.out.println("\n--- Add Two Numbers Tests (Linked List Sum) ---");

        System.out.printf("%-15s | %-15s | %-25s | %-25s | %-5s\n",
                "Input 1 (Rev)", "Input 2 (Rev)", "Expected Output (Truncated)", "Actual Output (Truncated)", "Result");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (int i = 0; i < nums1List.size(); i++) {

            ListNode l1 = createList(nums1List.get(i));
            ListNode l2 = createList(nums2List.get(i));
            ListNode expectedNode = createList(expectedArrayList.get(i));

            ListNode actualNode = solver.addTwoNumbers(l1, l2);

            String expectedStrFull = listToString(expectedNode);
            String actualStrFull = listToString(actualNode);

            String inputStr1 = truncateString(listToString(l1), 15);
            String inputStr2 = truncateString(listToString(l2), 15);
            String expectedStrDisplay = truncateString(expectedStrFull, 25);
            String actualStrDisplay = truncateString(actualStrFull, 25);

            boolean passed = compareLists(expectedNode, actualNode);
            String resultStatus = passed ? "PASS" : "FAIL";

            System.out.printf("%-15s | %-15s | %-27s | %-25s | %-5s\n",
                    inputStr1, inputStr2, expectedStrDisplay, actualStrDisplay, resultStatus);
        }

        System.out.println("----------------------------------------------------------------------------------------------------\n");
    }

    /**
     * Adds two numbers represented by non-empty linked lists. The digits are stored
     * in reverse order, and each of their nodes contains a single digit.
     * * The method uses a single pass with a carry variable to sum the lists.
     *
     * @param l1 The head of the first linked list (number 1).
     * @param l2 The head of the second linked list (number 2).
     * @return The head of the resulting linked list, representing the sum of the two numbers.
     * @author Dela Cruz, Angelika
     * @author Mabalot, Rod Clarenz
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return temp.next;
    }

    // --- Helper Methods for Testing ---
    /** Truncates a string for clean table display, adding "..." if necessary. */
    private static String truncateString(String s, int maxLength) {
        if (s.length() > maxLength) {
            return s.substring(0, maxLength - 3) + "...";
        }
        return s;
    }

    /** Creates a linked list from an integer array. */
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /** Converts a linked list to a string representation. */
    private static String listToString(ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /** Compares two linked lists for equality. */
    private static boolean compareLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}
