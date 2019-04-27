
/*
 * [231] Power of Two
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (40.83%)
 * Total Accepted:    173.2K
 * Total Submissions: 424.3K
 * Testcase Example:  '1'
 *
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: true
 * 
 * Example 2:
 * 
 * 
 * Input: 16
 * Output: true
 * 
 * Example 3:
 * 
 * 
 * Input: 218
 * Output: false
 * 
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n != 0) {
            if (n % 2 == 1) {
                if (n != 1)
                    return false;
                else
                    return true;
            }
            n /= 2;
        }
        return false;
    }
}
