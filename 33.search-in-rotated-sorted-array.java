/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (31.91%)
 * Total Accepted:    254.7K
 * Total Submissions: 798.4K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int medium = (nums.length-1)/2;
        if(nums[medium]==target)return medium;
        return Math.max(help(nums, 0, medium-1, target), help(nums, medium+1, nums.length-1, target));
    }

    public int help(int[] nums, int start, int end, int target){
        int medium = (end+start)/2;
        if(nums[medium]==target) return medium;
        if(start>end||(start==end&&nums[start]==target)) return -1;
        if(nums[end]>nums[start]){
            if(target>nums[end]||target<nums[start]) return -1; 
        }
        return Math.max(help(nums, start, medium-1, target), help(nums, medium+1, end, target));
    }
}
