/*
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (27.15%)
 * Total Accepted:    225.4K
 * Total Submissions: 830.2K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "race a car"
 * Output: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll(" ", "");
        s = s.replaceAll(",", "");
        s = s.replaceAll(":", "");
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (!(s.charAt(start) > 'A' && s.charAt(start) < 'Z')
                    || (s.charAt(start) > 'a' && s.charAt(start) < 'z')) {
                if (start >= end)
                    break;
                start++;
            }

            while (!(s.charAt(end) > 'A' && s.charAt(end) < 'Z') || (s.charAt(end) > 'a' && s.charAt(end) < 'z')) {
                if (start >= end)
                    break;
                end--;
            }
            if (start >= end)
                break;
            if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--)))
                return false;

        }
        return true;
    }
}
