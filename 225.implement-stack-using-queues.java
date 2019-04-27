import java.util.LinkedList;
import java.util.Queue;

/*
 * [225] Implement Stack using Queues
 *
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (34.48%)
 * Total Accepted:    94.8K
 * Total Submissions: 275.1K
 * Testcase Example:  '["MyStack","empty"]\n[[],[]]'
 *
 * 
 * Implement the following operations of a stack using queues.
 * 
 * 
 * push(x) -- Push element x onto stack.
 * 
 * 
 * pop() -- Removes the element on top of the stack.
 * 
 * 
 * top() -- Get the top element.
 * 
 * 
 * empty() -- Return whether the stack is empty.
 * 
 * 
 * Notes:
 * 
 * You must use only standard operations of a queue -- which means only push to
 * back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * all test cases.
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        int tmp = q1.poll();
        while (!q1.isEmpty()) {
            q2.offer(tmp);
            tmp = q1.poll();
        }
        return tmp;
    }

    /** Get the top element. */
    public int top() {
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        int tmp = q1.poll();
        while (!q1.isEmpty()) {
            q2.offer(tmp);
            tmp = q1.poll();
        }
        q2.offer(tmp);
        return tmp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if (q1.isEmpty() && q2.isEmpty())
            return true;
        else
            return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
