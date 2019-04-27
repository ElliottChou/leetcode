/*
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (38.43%)
 * Total Accepted:    146.4K
 * Total Submissions: 381K
 * Testcase Example:  '3'
 *
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 * 
 * Example:
 * 
 * 
 * Input: 3
 * Output: [1,3,3,1]
 * 
 * 
 * Follow up:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        if(numRows==0)return tmp;
        // lists.add(new ArrayList<Integer>(1));
        
        lists.add(new ArrayList<>(tmp));
        return generatehelp(lists, numRows);
    }
    public List<Integer> generatehelp(List<List<Integer>> lists, int numRows){
        if(numRows==0) return lists.get(lists.size()-1);
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
