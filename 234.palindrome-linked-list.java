/*
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (33.59%)
 * Total Accepted:    160.9K
 * Total Submissions: 479K
 * Testcase Example:  '[1,2]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2
 * Output: false
 * 
 * Example 2:
 * 
 * 
 * Input: 1->2->2->1
 * Output: true
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        while (tmp.next != null) {
            size++;
            tmp = tmp.next;
        }
        if (size % 2 == 0) {
            size = size / 2 + 1;
        } else {
            size = size / 2 + 2;
        }
        tmp.next = head;
        while (size != 0) {
            tmp = tmp.next;
            size--;
        }
        reverseList(tmp);
        ListNode ln = head;
        if (ln.val != tmp.val)
            return false;
        while (tmp.next != null) {
            tmp = tmp.next;
            ln = ln.next;
            if (ln.val != tmp.val)
                return false;
        }
        return true;
    }

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
