/*
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (39.84%)
 * Total Accepted:    243.5K
 * Total Submissions: 611.1K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {

        int cnt = 1;
        int length = digits.length;
        for(int i = length-1; i>=0; i--){
            int tmp = digits[i];
            digits[i] = (tmp+cnt)%10;
            cnt = (tmp+cnt)/10;
        }
        if(cnt==0)return digits;
        int[] newd = new int[digits.length+1];
        newd[0] = 1;
        int index = 1;
        for (int var : digits) {
            newd[index++] = var;
        }
        return newd;
    }
}
