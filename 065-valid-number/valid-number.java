// Validate if a given string can be interpreted as a decimal number.
//
// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// " -90e3   " => true
// " 1e" => false
// "e3" => false
// " 6e-1" => true
// " 99e2.5 " => false
// "53.5e93" => true
// " --6 " => false
// "-+3" => false
// "95a54e53" => false
//
// Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
//
//
// 	Numbers 0-9
// 	Exponent - "e"
// 	Positive/negative sign - "+"/"-"
// 	Decimal point - "."
//
//
// Of course, the context of these characters also matters in the input.
//
// Update (2015-02-10):
// The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
//


public class Solution {
    public boolean isNumber(String s) {
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
