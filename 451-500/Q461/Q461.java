package com.thunisoft.leetcode;

import java.util.Arrays;

public class Q461 {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 4, 3, 2 };
        System.out.println(arrayPairSum(array));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];
        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (l > low)
            quickSort(arr, low, l - 1);
        if (h < high)
            quickSort(arr, l + 1, high);
    }
}
