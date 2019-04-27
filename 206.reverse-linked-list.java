/*
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (47.04%)
 * Total Accepted:    351.4K
 * Total Submissions: 747.1K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        int size = 1;
        ListNode tail = head;
        ListNode tmp;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        ListNode hhead = new ListNode(0);
        hhead.next = head;
        while (size-- != 1) {
            tmp = hhead.next;
            hhead.next = tmp.next;
            tmp.next = tail.next;
            tail.next = tmp;

        }
        return hhead.next;
    }
}
