import java.util.ArrayList;

import java.util.List;

/*
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (40.35%)
 * Total Accepted:    172.2K
 * Total Submissions: 426.8K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(numRows==0)return lists;
        // lists.add(new ArrayList<Integer>(1));
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        lists.add(new ArrayList<>(tmp));
        return generatehelp(lists, numRows-1);
    }

    public List<List<Integer>> generatehelp(List<List<Integer>> lists, int numRows){
        if(numRows==0) return lists;
        List<Integer> list = lists.get(lists.size()-1);
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        for (int i = 1; i <= list.size()-1; i++) {
            tmp.add(list.get(i-1)+list.get(i));
        }
        tmp.add(1);
        lists.add(new ArrayList<>(tmp));
        return generatehelp(lists, numRows-1);
    }
}
