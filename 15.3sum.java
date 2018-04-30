import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

/*
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (21.80%)
 * Total Accepted:    320.4K
 * Total Submissions: 1.5M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
    
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length<3)
            return lists;
        int left = 0, right = 0, sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            left = i + 1; right = nums.length-1;
            if(nums[i]>=0&&nums[left]>0)
                break;
            int s = 0 - nums[i];
            while (left<right&&(nums[nums.length-1]+nums[nums.length-2]>=s||nums[i+1]+nums[i+2]<=s)) {
                sum = nums[left]+nums[right];
                if(sum==s){
                    List<Integer> list = new ArrayList<Integer>();
                    list = Arrays.asList(nums[i],nums[left],nums[right]);
                    if(!lists.contains(list))
                        lists.add(list);
                    while(left<right && nums[left]==nums[left+1])left++;
                    while(left<right&& nums[right]==nums[right-1])right--;
                    left++;right--;
                }else if(sum>s){
                    right--;
                }else
                    left++;
            }
        }
        return lists;
    }
}
