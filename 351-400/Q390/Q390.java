package com.thunisoft.leetcode;

public class Q390 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
    }

    public static int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        } else if (n % 2 == 1) {
            return lastRemaining(n - 1);
        } else {
            int halfN = n/2;
            return 2 * (halfN+1-lastRemaining(halfN));
        }
    }

}
