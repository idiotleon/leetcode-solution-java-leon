/**
 * https://leetcode.com/problems/zuma-game/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/zuma-game/discuss/557563/Short-Java-Brute-Force-Solution
 */
package com.an7one.leetcode.lvl6.lc0488;

public class SolutionApproach1DFSNaively {
    public int findMinStep(String board, String hand) {
        int[] minSteps = new int[]{Integer.MAX_VALUE};
        dfs(board, hand, minSteps, 0, 0);
        return minSteps[0] == Integer.MAX_VALUE ? -1 : minSteps[0];
    }
    
    private void dfs(String board, String hand, int[] minSteps, int steps, int lastIdx){
        if(board.length() == 0) 
            minSteps[0] = Math.min(minSteps[0], steps);
        
        for(int i = lastIdx; i < hand.length(); i++){
            for(int j = 0; j <= board.length(); j++){
                String newHand = hand.substring(0, i) + hand.substring(i + 1);
                String newBoard = play(board.substring(0, j) + hand.charAt(i) + board.substring(j));
                dfs(newBoard, newHand, minSteps, steps + 1, i);
            }
        }
    }
    
    private String play(String str){
        final int L = str.length();
        for(int i = 0, j = 0; j < L; j++){
            while(j < L && str.charAt(i) == str.charAt(j)) j++;
            if(j - i >= 3) return play(str.substring(0, i) + str.substring(j));
            else i = j;
        }
        return str;
    }
}