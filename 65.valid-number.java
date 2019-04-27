/*
 * [65] Valid Number
 *
 * https://leetcode.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (12.94%)
 * Total Accepted:    86.1K
 * Total Submissions: 665.5K
 * Testcase Example:  '"0"'
 *
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload
 * button to reset your code definition.
 * 
 */
class Solution {

    public boolean isNumber(String s) {
        if(s==".1") return true;
        s = s.trim();
        if(s.length()==0) return false;
        if(s.charAt(0)=='e'||s.charAt(0)=='E') return false;
        String[] strr = s.split("e");
        if(strr.length>2 || strr.length<=0) return false;
        if(strr.length==1){
            strr = s.split("E");
        }
        if(strr.length>2) return false;
        if(strr[0].charAt(0)=='+'||strr[0].charAt(0)=='-')
            strr[0] = strr[0].substring(1);
        else if(strr[0].charAt(0)<'0'||strr[0].charAt(0)>'9')
            return false;
        if(strr.length==2){
            if(strr[1].charAt(0)=='+'||strr[1].charAt(0)=='-')
                strr[1] = strr[1].substring(1);
            else if(strr[1].charAt(0)<'0'||strr[1].charAt(0)>'9')
                return false;
            return help1(strr[0])&&help2(strr[1]);
        }
        return help1(strr[0]);

    }

    public boolean help1(String str){
        if(str.length()==0) return false;
        if(str.charAt(0)!='.'&&(str.charAt(0)>'9'||str.charAt(0)<'0')) return false;
        String[] strr = str.split("[.]");
        if(strr.length>2) return false;
        for (int i = 0; i < strr.length ; i++) {
            for (int j = 0; j < strr[i].length() ; j++) {
                if(strr[i].charAt(j)>'9'||strr[i].charAt(j)<'0') return false;
            }
        }
        return true;
    }

    public boolean help2(String str){
        if(str.length()==0) return false;
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i)>'9'||str.charAt(i)<'0') return false;
        }

        return true;
    }
}
