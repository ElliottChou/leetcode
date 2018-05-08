import java.util.ArrayList;

import java.util.List;;

/*
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (24.10%)
 * Total Accepted:    239.5K
 * Total Submissions: 993.8K
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's
 * value
 * is 5 but its right child's value is 4.
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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return false;
        List<Integer> list = new ArrayList<Integer>();
        if(list.size()==0)return false;
        if(list.size()==1)return true;
        help(root, list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)<=lis.get(i-1))return false;
        }
        return true;
    }

    public void help(TreeNode root, List<Integer> list){
        if(root.left!=null) help(root.left,list);
        list.add(root.val);
        if(root.right!=null) help(root.right, list);
    }
}
