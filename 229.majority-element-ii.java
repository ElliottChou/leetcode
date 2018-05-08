import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (29.24%)
 * Total Accepted:    70.8K
 * Total Submissions: 242.3K
 * Testcase Example:  '[]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        if(nums.length==0) return list;
        int index = 0;
        int length = nums.length/3;
        while(index+length<nums.length){
            if(nums[index]==nums[index+length]){
                if(!list.contains(nums[index])) list.add(nums[index]);
                index = index + length + 1;
            }else
                index++;
        }
        return list;
    }
}
