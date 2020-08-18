/**
 * https://leetcode.com/problems/valid-perfect-square/
 * 
 * Time Complexity: O(lg(num))
 * Space Complexity: O(1)
 * 
 * to take care of integer - stackoverflow
 * 
 * References:
 *  https://leetcode.com/problems/valid-perfect-square/discuss/83874/A-square-number-is-1%2B3%2B5%2B7%2B...-JAVA-code
 */
package com.zea7ot.leetcode.lvl3.lc0367;

public class SolutionApproach1BinarySearch {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        
        long left = 0, right = num / 2;
        while(left <= right){
            long mid = left + (right - left) / 2;
            // to take care of stackoverflow
            long guess = mid * mid;
            if(guess == num) return true;
            if(guess > num) right = mid - 1;
            else left = mid + 1;
        }
        
        return false;
    }
}