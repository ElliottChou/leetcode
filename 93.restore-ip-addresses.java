import java.util.ArrayList;

/*
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (28.54%)
 * Total Accepted:    103.5K
 * Total Submissions: 362.5K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> lists = new ArrayList<>();
        int[] tmp = new int[4];
        for (int i = 1; i <= 3; i++) {
            tmp[0] = Integer.valueOf(s.substring(0, i));
            if(tmp[0]<=255)
                help(s.substring(i), tmp, 0, lists);
        }
    }
    public void hepl(String s, int[] tmp, int index, List<String> lists){

    }
}
