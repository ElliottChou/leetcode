/*
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (35.05%)
 * Total Accepted:    132.6K
 * Total Submissions: 378.2K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;
        int rows = triangle.size();int cols = triangle.get(rows-1).size();
        int[] tmp = new int[cols];
        int index = 0;
        for (int var : triangle.get(rows-1)) {
            tmp[index++] = var;
        }
        for (int i = rows-2; i >= 0; i--) {
            for (int j = 0; j <= triangle.get(i).size()-1 ; j++) {
                tmp[j] = triangle.get(i).get(j) + Math.min(tmp[j], tmp[j+1]);
            }
        }
        return tmp[0];
    }
}
