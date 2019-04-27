/*
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (40.56%)
 * Total Accepted:    253.5K
 * Total Submissions: 624.9K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 
 * But the following [1,2,2,null,3,null,3]  is not:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode pRoot) {
        if(pRoot==null)return true;
        TreeNode sroot = new TreeNode(pRoot.val);
        sroot.left = builttree(pRoot.right);
        sroot.right = builttree(pRoot.left);
        return issame(sroot, pRoot);
    }

    public boolean issame(TreeNode root, TreeNode pRoot){
        if(root==null&&pRoot==null) return true;
        if(root==null||pRoot==null) return false;
        if(root.val!=pRoot.val) return false;
        return issame(root.left, pRoot.left)&&issame(root.right, pRoot.right);
    }

    public TreeNode builttree(TreeNode pRoot){
        if(pRoot==null) return null;
        TreeNode sroot = new TreeNode(pRoot.val);
        sroot.left = builttree(pRoot.right);
        sroot.right = builttree(pRoot.left);
        return sroot;
    }
}
