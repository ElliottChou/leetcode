import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (24.36%)
 * Total Accepted:    388.7K
 * Total Submissions: 1.6M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123
 * Output:  321
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only hold integers
 * within the 32-bit signed integer range. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        int negative = 1;
        if(x<0){
            negative = -1;
            x = -x;
        }
        Queue<Integer> stack = new LinkedList<>();
        while (x!=0) {
            stack.offer(x%10);
            x /= 10;
        }
        while (!stack.isEmpty()) {
            x = x*10 + stack.poll();
            if(negative==1&& x>Integer.MAX_VALUE/10&&!stack.isEmpty())
                return 0;
            if(negative==1&&x==Integer.MAX_VALUE/10&&!stack.isEmpty()&&stack.peek()>Integer.MAX_VALUE%10)
                return 0;
            if(negative==-1&& x>(-1*Integer.MIN_VALUE)/10&&!stack.isEmpty())
                return 0;
            if(negative==-1&&x==(-1*Integer.MIN_VALUE)/10&&!stack.isEmpty()&&stack.peek()>(-1*Integer.MIN_VALUE)%10)
                return 0;
        }
        return negative*x;
    }
}
