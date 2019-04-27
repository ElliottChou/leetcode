/*
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.64%)
 * Total Accepted:    273.5K
 * Total Submissions: 864.6K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * 
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<2)return "";
        if(strs.length==1)return strs[0];
        int index = 0;
        while(index<strs[0].length()&&index<strs[1].length()){
            if(strs[0].charAt(index)==strs[1].charAt(index)) index++;
            else break;
        }
        for (int i = 2; i < strs.length; i++) {
            if(index==0) return "";
            if(strs[i].length()==0) return "";
            index = strs[i].length()<index? strs[i].length():index;
            for (int j = 0; j < index; j++) {
                if(strs[i].charAt(j)!=strs[0].charAt(j)){
                    index = j; break;
                }
            }
        }
        return strs[0].substring(0, index);
    }
}
