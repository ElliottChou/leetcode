import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (36.14%)
 * Total Accepted:    151.5K
 * Total Submissions: 419.2K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sums to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note:
 * 
 * 
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            list.add(candidates[i]);
            if(target-candidates[i]>=0)
                help(lists, list, candidates, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
        return lists;
    }

    public void help(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int index) {
        if(target==0){
            if(!lists.contains(list))
                lists.add(new ArrayList(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            if(target-candidates[i]>=0)
                help(lists, list, candidates, target-candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }
}
