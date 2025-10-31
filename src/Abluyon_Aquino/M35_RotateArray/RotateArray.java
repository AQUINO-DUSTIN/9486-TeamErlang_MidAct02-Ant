 package Abluyon_Aquino.M35_RotateArray;

class RotateArray {

public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    int n = nums.length;

    k %= n;

    // Reverse the whole array
    for (int start = 0, end = n - 1; start < end; start++, end--) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    // Reverse first k elements
    for (int start = 0, end = k - 1; start < end; start++, end--) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    // Reverse remaining elements
    for (int start = k, end = n - 1; start < end; start++, end--) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    System.out.print("Rotated Array: ");
    for (int num : nums) {
        System.out.print(num + " ");
    }
}
}