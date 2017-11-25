package com.thunisoft.leetcode;

public class Q561 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int m = 0;
        while (n!=0) {
            if((n & 1) == 1) {
                m ++;
            }
            n = n>>1;
        }
        return m;
    }

}
