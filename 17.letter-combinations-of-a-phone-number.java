/*
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (36.75%)
 * Total Accepted:    237K
 * Total Submissions: 645.1K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] pn = new String[10];
        pn[2] = "abc"; pn[3] = "def"; pn[4] = "ghi"; pn[5] = "jkl"; pn[6] = "mno"; pn[7] = "pqrs"; pn[8] = "tuv"; pn[9] = "wxyz";
        List<String> list = new ArrayList<String>();
        if(digits.length()==0) return list;
        String tmp = "";
        for (int i = 0; i < pn[digits.charAt(0)-'0'].length(); i++) {
            tmp = tmp + pn[digits.charAt(0)-'0'].charAt(i);
            help(list, tmp, pn, digits.substring(1));
            tmp = tmp.substring(0, tmp.length()-1);
        }
        return list;
    }
    public void help(List<String> list, String tmp, String[] pn, String digits){
        if(digits.length()==0){
            list.add(tmp); return;
        }
        for (int i = 0; i < pn[digits.charAt(0)-'0'].length(); i++) {
            tmp = tmp + pn[digits.charAt(0)-'0'].charAt(i);
            help(list, tmp, pn, digits.substring(1));
            tmp = tmp.substring(0, tmp.length()-1);
        }
    }
}
