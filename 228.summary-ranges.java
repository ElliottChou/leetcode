import java.util.ArrayList;
import java.util.List;

/*
 * [228] Summary Ranges
 *
 * https://leetcode.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (32.37%)
 * Total Accepted:    100.1K
 * Total Submissions: 309.2K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * Example 1:
 * 
 * 
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i - start) != (nums[i] - nums[start])) {
                if (i - 1 == start)
                    list.add(String.valueOf(nums[start]));
                else
                    list.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[i - 1]));
                start = i;
            }
        }
        if (start == nums.length - 1)
            list.add(String.valueOf(nums[start]));
        else
            list.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[nums.length - 1]));
        return list;
    }
}
