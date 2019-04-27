import java.util.Arrays;

/*
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (29.69%)
 * Total Accepted:    103.2K
 * Total Submissions: 347.6K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        if(n<=0)return "";
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = i+1;
        }
        while(k--!=1) gphelp(tmp);
        String str = "";
        for (int var : tmp) {
            str = str + String.valueOf(var);
        }
        return str;

    }
    public void gphelp(int[] tmp){
        int idx = -1;
        for(int i = tmp.length-2; i >= 0; i --){
            if(tmp[i]<tmp[i+1]){
                idx = i; break;
            } 
        }
        if(idx == -1) return;
        for(int i = tmp.length-1; i >= 0; i --){
            if(tmp[idx]<tmp[i]){
                int tmpp = tmp[idx]; tmp[idx] = tmp[i]; tmp[i] = tmpp;
                break;
            }
        }
        Arrays.sort(tmp, idx+1, tmp.length);
    }
}
