import java.util.Stack;

/*
 * [232] Implement Queue using Stacks
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * algorithms
 * Easy (38.27%)
 * Total Accepted:    107.4K
 * Total Submissions: 280.7K
 * Testcase Example:  '["MyQueue","empty"]\n[[],[]]'
 *
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * 
 * push(x) -- Push element x to the back of queue.
 * 
 * 
 * pop() -- Removes the element from in front of queue.
 * 
 * 
 * peek() -- Get the front element.
 * 
 * 
 * empty() -- Return whether the queue is empty.
 * 
 * 
 * Notes:
 * 
 * You must use only standard operations of a stack -- which means only push to
 * top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 * 
 * 
 */
class MyQueue {

    Stack<Integer> stackin;
    Stack<Integer> stackout;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stackin = new Stack<Integer>();
        this.stackout = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stackout.isEmpty()) {
            stackin.push(stackout.pop());
        }
        stackin.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stackin.isEmpty()) {
            stackout.push(stackin.pop());
        }
        return stackout.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stackin.isEmpty()) {
            stackout.push(stackin.pop());
        }
        return stackout.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stackin.isEmpty() && stackout.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
