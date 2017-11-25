package com.thunisoft.leetcode;

public class Q479 {

    public static void main(String[] args) {
        System.out.println(largestPalindrome(1));

    }

    public static int largestPalindrome(int n) {

        long k = ((long) Math.pow(10, n) - 1);
        long kMax = k;
        long mMax = k * k;

        while (k > 0) {

            String firstHalfStr = String.valueOf(k);
            String valueStr = firstHalfStr
                    + new StringBuilder(firstHalfStr).reverse().toString();
            long m = Long.parseLong(valueStr);
            k--;
            long kIndex = kMax;
            while (m % kIndex != 0) {
                kIndex--;
                long l = m / kIndex;
                if (l <= kMax) {
                    return (int) (m % 1337);
                } else if (m < mMax) {
                    break;
                }
            }

        }
        return 0;
    }

}
