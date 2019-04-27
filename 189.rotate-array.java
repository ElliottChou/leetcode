/*
 * [189] Rotate Array
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (25.49%)
 * Total Accepted:    183.7K
 * Total Submissions: 720.9K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation: 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(nums.length==2 && k%2==1){
            int tmp = nums[0]; nums[0]=nums[1];nums[1]=tmp;
            return;
        }
        if(nums.length<=1) return;
        if(k>nums.length-1||k<=0) return;
        rhelp(nums, 0, nums.length-k-1);
        rhelp(nums, nums.length-k, nums.length-1);
        rhelp(nums, 0, nums.length-1);
        return;
    }

    public void rhelp(int[] nums, int start, int end){
        int tmp;
        while(start<end){
            tmp = nums[start]; nums[start] = nums[end]; nums[end] = tmp;
            start++;end--;
        }
        return;
    }
}
