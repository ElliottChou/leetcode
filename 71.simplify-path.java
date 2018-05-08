/*
 * [71] Simplify Path
 *
 * https://leetcode.com/problems/simplify-path/description/
 *
 * algorithms
 * Medium (26.38%)
 * Total Accepted:    112.7K
 * Total Submissions: 427.3K
 * Testcase Example:  '"/home/"'
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * click to show corner cases.
 * 
 * Corner Cases:
 * 
 * 
 * 
 * 
 * 
 * 
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together,
 * such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * 
 */
class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        if(str.length==0 || str[str.length-1].equals(".")) return "/";
        String aa = str[str.length-1];
        String[] strr = aa.split("[.]");
        if(strr.length==0) {
            if(aa.equals("...")){
                if(str[str.length-2].length()==0)
                    return "/"+aa;
                else return "/"+str[str.length-2]+"/"+aa;
            }
            else return "/";
        }
        return "/"+strr[strr.length-1];
    }
}
