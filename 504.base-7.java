import java.util.Stack;

/*
 * [504] Base 7
 *
 * https://leetcode.com/problems/base-7/description/
 *
 * algorithms
 * Easy (43.92%)
 * Total Accepted:    28.2K
 * Total Submissions: 64.3K
 * Testcase Example:  '100'
 *
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1:
 * 
 * Input: 100
 * Output: "202"
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: -7
 * Output: "-10"
 * 
 * 
 * 
 * Note:
 * The input will be in range of [-1e7, 1e7].
 * 
 */
class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        int inte = num < 0 ? -1 : 1;
        num = inte * num;
        String str = "";
        Stack<Integer> stack = new Stack<>();
        while(num>0){
            stack.push(num%7);
            num /= 7;
        }
        while(!stack.isEmpty()){
            str = str + String.valueOf(stack.pop());
        }
        if(inte == -1) return "-"+str;
        return str;
    }
}
