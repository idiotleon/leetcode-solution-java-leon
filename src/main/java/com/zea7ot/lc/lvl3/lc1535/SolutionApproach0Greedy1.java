/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-winner-of-an-array-game/discuss/767916/Java-or-Easy-one-or-One-pass
 */
package com.zea7ot.lc.lvl3.lc1535;

public class SolutionApproach0Greedy1 {
    public int getWinner(int[] arr, int k) {
        final int N = arr.length;
        
        int winner = arr[0];
        int wins = 0;
        for(int i = 1; i < N; ++i){
            if(winner > arr[i]) ++wins;
            else{
                wins = 1;
                winner = arr[i];
            }
            
            if(wins == k) break;
        }
        
        return winner;
    }
}