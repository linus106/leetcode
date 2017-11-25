package com.thunisoft.leetcode;


public class Q65 {

    public static void main(String[] args) {
        System.out.println(isNumber("32.e-80123"));
    }

    public static boolean isNumber(String s) {
        //[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
        String numStr = s.trim();
        
        boolean operatorSeen = false;
        boolean numberSeen = false;
        boolean pointSeen = false;
        
        boolean eSeen = false;
        boolean eNumberSeen = true;
        
        for (int i = 0;i< numStr.length(); i++) {
            char c = numStr.charAt(i);
            if(c == '+' || c == '-') {
                if(pointSeen || operatorSeen || (numberSeen && !eSeen) || (eSeen && eNumberSeen)) {
                    return false;
                }
                operatorSeen = true;
            } else if(c <= '9' && c>='0') {
                if (eSeen) {
                    eNumberSeen = true;
                } else {
                    numberSeen = true;
                }
            } else if(c == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(c == 'e') {
                if(eSeen) {
                    return false;
                }
                eSeen = true;
                operatorSeen = false;
                eNumberSeen = false;
                pointSeen = false;
            } else {
                return false;
            }
        }
        return numberSeen && eNumberSeen;
    }

}
