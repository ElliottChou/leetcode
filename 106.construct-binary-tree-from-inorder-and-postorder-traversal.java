import java.util.Arrays;

/*
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (33.83%)
 * Total Accepted:    107.8K
 * Total Submissions: 318.7K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * 
 * Return the following binary tree:
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0) {
            return null;
        }
        TreeNode foo = new TreeNode(postorder[postorder.length-1]);
        int is, ie, ps, pe;
        int index = 0;
        while(inorder[index]!=postorder[postorder.length-1]) index++;
        if(index-1>=0)
            foo.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        if(index<postorder.length-1)
            foo.right = buildTree(Arrays.copyOfRange(inorder, index+1, postorder.length), Arrays.copyOfRange(postorder, index, postorder.length-1));
        return foo;

    }
}
