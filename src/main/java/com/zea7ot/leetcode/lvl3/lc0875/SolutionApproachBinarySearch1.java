/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * 
 * Time Complexity: O(Nlg(M))
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0875;

public class SolutionApproachBinarySearch1 {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1, right = 1000000000;
        while(left < right){
            int totalHours = 0;
            int mid = left + (right - left) / 2;
            for(int pile : piles){
                totalHours += Math.ceil((float)pile / mid);
            }
            if(totalHours > H) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}