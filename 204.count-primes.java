/*
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (26.55%)
 * Total Accepted:    157K
 * Total Submissions: 591.3K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
// class Solution {
//     public int countPrimes(int n) {
//         if (n == 0 || n == 1)
//             return 0;
//         int count = 0;
//         n--;
//         while (n != 1) {
//             if (help(n--) == true)
//                 count++;
//         }
//         return count;
//     }

//     public boolean help(int n) {

//         for (int i = 2; i <= (int) Math.sqrt(n); i++) {
//             if (n % i == 0)
//                 return false;
//         }

//         return true;
//     }
// }

import java.util.ArrayList;

public class Solution {

    public int countPrimes(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num;
        for (int i = 2; i < n; i++) {
            num = i;
            boolean b = isPrime(num);
            if (b) {
                list.add(num);
            }
        }
        if (n > 2) {
            list.add(2);
        }
        return list.size();
    }

    boolean isPrime(int n) {
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}