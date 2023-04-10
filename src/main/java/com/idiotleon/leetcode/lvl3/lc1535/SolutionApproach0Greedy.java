/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-winner-of-an-array-game/discuss/768007/JavaC%2B%2BPython-One-Pass-O(1)-Space
 */
package com.idiotleon.leetcode.lvl3.lc1535;

public class SolutionApproach0Greedy {
    public int getWinner(int[] arr, int k) {
        final int N = arr.length;
        int winner = arr[0], win = 0;
        
        for(int i = 1; i < N; ++i){
            if(arr[i] > winner){
                winner = arr[i];
                win = 0;
            }
            
            if(++win == k) break;
        }
        
        return winner;
    }
}