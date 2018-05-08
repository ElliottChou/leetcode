/*
 * [169] Majority Element
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (48.11%)
 * Total Accepted:    259.9K
 * Total Submissions: 540.3K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0) return -1;
        int num = nums[nums.length/2];
        int index = 0;
        for (int var : nums) {
            if(num==var)index++;
        }
        if(index<nums.length/2) return -1;
        return num;
    }
}
