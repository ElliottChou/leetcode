/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (41.79%)
 * Total Accepted:    57.5K
 * Total Submissions: 137.5K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int cnt = 0;
        int tmp = 0;
        String str = "";
        while (idx1 >= 0 && idx2 >= 0) {
            tmp = num1.charAt(idx1--) - '0' + num2.charAt(idx2--) - '0' + cnt;
            str = String.valueOf(tmp % 10) + str;
            cnt = tmp / 10;
        }
        while (idx1 >= 0) {
            tmp = num1.charAt(idx1--) - '0' + cnt;
            str = String.valueOf(tmp % 10) + str;
            cnt = tmp / 10;
        }
        while (idx2 >= 0) {
            tmp = num2.charAt(idx2--) - '0' + cnt;
            str = String.valueOf(tmp % 10) + str;
            cnt = tmp / 10;
        }
        if (cnt == 1)
            str = '1' + str;
        return str;
    }
}
