import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (47.75%)
 * Total Accepted:    238.2K
 * Total Submissions: 498.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length==0) return lists;
        lists.add(new ArrayList(Arrays.asList(nums)));
        while(gphelp(nums, lists)==true);
        return lists;
    }
    public boolean gphelp(int[] tmp, List<List<Integer>> lists){
        int idx = -1;
        for(int i = tmp.length-2; i >= 0; i --){
            if(tmp[i]<tmp[i+1]){
                idx = i; break;
            } 
        }
        if(idx == -1) return false;
        for(int i = tmp.length-1; i >= 0; i --){
            if(tmp[idx]<tmp[i]){
                int tmpp = tmp[idx]; tmp[idx] = tmp[i]; tmp[i] = tmpp;
                break;
            }
        }
        Arrays.sort(tmp, idx+1, tmp.length);
        lists.add(new ArrayList(Arrays.asList(tmp)));
        return true;
    }
}
