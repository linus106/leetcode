package com.thunisoft.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q420 {

    public static void main(String[] args) {
        System.out.println(strongPasswordChecker("..."));
    }

    public static int strongPasswordChecker(String s) {
        int length = s.length();
        int more = 0;
        int less = 0;
        int specialLess = 0;
        boolean digit = false;
        boolean lowercase = false;
        boolean uppercase = false;
        List<Integer> moreThan2 = new ArrayList<Integer>();
        if (length > 20) {
            more = length - 20;
        } else if (length < 6) {
            less = 6 - length;
        }

        char lastChar = '\0';
        int lastCharCount = 0;

        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                digit = true;
            } else if (c <= 'z' && c >= 'a') {
                lowercase = true;
            } else if (c <= 'Z' && c >= 'A') {
                uppercase = true;
            }
            if (lastChar == c) {
                lastCharCount++;
            } else {
                if (lastCharCount > 2) {
                    moreThan2.add(lastCharCount - 2);
                }
                lastChar = c;
                lastCharCount = 1;
            }
        }
        if (lastCharCount > 2) {
            moreThan2.add(lastCharCount - 2);
        }

        int add = less;
        int minus = more;
        specialLess = (digit ? 0 : 1) + (lowercase ? 0 : 1) + (uppercase ? 0 : 1);
        int dealSpecial = specialLess > add ? specialLess - add : 0;

        int one = 0;
        int two = 0;
        int three = 0;
        for (int n : moreThan2) {
            three += (n / 3);
            if (n % 3 == 2) {
                two++;
            } else if (n % 3 == 1) {
                one++;
            }
        }

        int matchOne = Math.min(minus, one);
        int minusLeft = minus - matchOne;
        int oneLeft = one - matchOne;

        int matchTwo = Math.min(add, two);
        int addLeft = add - matchTwo;
        int twoLeft = two - matchTwo;
        
        int threeLeft= three;

        if (minusLeft >= 2 && twoLeft > 0) {
            int minusMatchTwo = Math.min(twoLeft, minusLeft / 2);
            minusLeft -= (minusMatchTwo * 2);
            twoLeft -= minusMatchTwo;
        }
        
        if (addLeft >= 1 && oneLeft > 0) {
            int addMatchOne = Math.min(addLeft, oneLeft);
            addLeft -= addMatchOne;
            oneLeft -= addMatchOne;
        }
        
        if (minusLeft >= 3 && threeLeft > 0) {
            int minusMatchThree = Math.min(threeLeft, minusLeft / 3);
            minusLeft -= (minusMatchThree * 3);
            threeLeft -= minusMatchThree;
        }
        
        return Math.max(dealSpecial, oneLeft + twoLeft + threeLeft) + add + minus;
    }

}
