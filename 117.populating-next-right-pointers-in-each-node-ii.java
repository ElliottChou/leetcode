/*
 * [117] Populating Next Right Pointers in Each Node II
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (33.90%)
 * Total Accepted:    131.5K
 * Total Submissions: 388K
 * Testcase Example:  '{}'
 *
 * Given a binary tree
 * 
 * 
 * struct TreeLinkNode {
 * ⁠ TreeLinkNode *left;
 * ⁠ TreeLinkNode *right;
 * ⁠ TreeLinkNode *next;
 * }
 * 
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * 
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra
 * space for this problem.
 * 
 * 
 * Example:
 * 
 * Given the following binary tree,
 * 
 * 
 * ⁠    1
 * ⁠  /  \
 * ⁠ 2    3
 * ⁠/ \    \
 * 4   5    7
 * 
 * 
 * After calling your function, the tree should look like:
 * 
 * 
 * ⁠    1 -> NULL
 * ⁠  /  \
 * ⁠ 2 -> 3 -> NULL
 * ⁠/ \    \
 * 4-> 5 -> 7 -> NULL
 * 
 * 
 */
/**
 * Definition for binary tree with next pointer. public class TreeLinkNode { int
 * val; TreeLinkNode left, right, next; TreeLinkNode(int x) { val = x; } }
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
        TreeLinkNode tmp = root;
        queue1.offer(root);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                tmp = queue1.poll();
                if (tmp.left != null)
                    queue2.offer(tmp.left);
                if (tmp.right != null)
                    queue2.offer(tmp.right);
                tmp.next = queue1.isEmpty() ? null : queue1.element();
            }
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
        }
        return;
    }
}
