import java.util.ArrayList;


/*
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (27.43%)
 * Total Accepted:    144.2K
 * Total Submissions: 525.8K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * Input:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lists = new ArrayList<Integer>();
        if(matrix.length==0) return lists;
        int start = 0;
        int endx = matrix.length-1;
        int endy = matrix[0].length-1;
        sohelp(lists, start, endx, endy, matrix);
        return lists;
    }
    public void sohelp(List<Integer> lists, int start, int endx, int endy, int[][] matrix){
        if(start>endx||start>endy) return;
        if(start==endx){
            for(int i = start; i<=endy; i++) lists.add(matrix[start][i]);
            return;
        }
        if(start==endy){
            for(int i= start; i<=endx; i++) lists.add(matrix[i][start]);
            return;
        }
        for(int i = start; i<=endy; i++) lists.add(matrix[start][i]);
        for(int i = start+1; i<=endx; i++) lists.add(matrix[i][endy]);
        for(int i = endy-1; i>=start; i--) lists.add(matrix[endx][i]);
        for(int i = endx-1; i>=start+1; i--) lists.add(matrix[i][start]);
        sohelp(lists, start+1, endx-1, endy-1,matrix);
    }
}
