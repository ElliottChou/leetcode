import java.util.ArrayList;

/*
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (34.86%)
 * Total Accepted:    138.1K
 * Total Submissions: 396K
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * Example 1:
 * 
 * 
 * Input: s = "egg", t = "add"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "foo", t = "bar"
 * Output: false
 * 
 * Example 3:
 * 
 * 
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        ArrayList<Character> list = new ArrayList<>();
        int[] sflag = new int[s.length()];
        int[] tflag = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i)))
                list.add(s.charAt(i));
            sflag[i] = list.indexOf(s.charAt(i));
        }
        list.clear();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(t.charAt(i)))
                list.add(t.charAt(i));
            tflag[i] = list.indexOf(t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (tflag[i] != sflag[i])
                return false;
        }
        return true;
    }
}
