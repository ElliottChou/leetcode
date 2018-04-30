import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (42.34%)
 * Total Accepted:    164K
 * Total Submissions: 387.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null) return lists;
        q1.offer(root);
        while(!q1.isEmpty()){
            List<Integer> foo = new ArrayList<Integer>();
            while (!q1.isEmpty()) {
                foo.add(q1.peek().val);
                if(q1.peek().left!=null) q2.offer(q1.peek().left);
                if(q1.peek().right!=null) q2.offer(q1.peek().right);
                q1.poll();
            }
            lists.add(0, new ArrayList(foo));
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }
        return lists;
    }
}
