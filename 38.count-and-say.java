import java.util.HashMap;

/*
 * [38] Count and Say
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (36.66%)
 * Total Accepted:    185.9K
 * Total Submissions: 507.2K
 * Testcase Example:  '1'
 *
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * 
 * 
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 * 
 * 
 * Note: Each term of the sequence of integers will be represented as a
 * string.
 * 
 * 
 * Example 1:
 * 
 * Input: 1
 * Output: "1"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 4
 * Output: "1211"
 * 
 * 
 */
class Solution {
    public String countAndSay(int n) {
        String str = "";
        if(n==0) return str;
        str = "1";
        return countAndSayhelp(str,n-1);
    }

    public String countAndSayhelp(String str, int n){
        if(n==0) return str;
        String newstr = "";
        int index = 0;
        char a = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==a){
                index++;
                if(i==str.length()-1)
                    newstr = newstr+String.valueOf(index)+String.valueOf(str.charAt(i));
            }
            else{
                newstr = newstr+String.valueOf(index)+String.valueOf(a);
                index = 1;
                a = str.charAt(i);
                if(i==str.length()-1)newstr = newstr+String.valueOf(index)+String.valueOf(a);
            }
        }
        return countAndSayhelp(newstr, n-1);
    }
}
