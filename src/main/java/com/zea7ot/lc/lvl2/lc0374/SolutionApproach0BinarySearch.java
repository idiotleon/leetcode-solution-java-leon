/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl2.lc0374;

public class SolutionApproach0BinarySearch extends FakeGuessGame{
    public int guessNumber(int n) {
        int left = 1, right = n;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(guess(mid) == 0) return mid;
            if(guess(mid) == 1) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }
}