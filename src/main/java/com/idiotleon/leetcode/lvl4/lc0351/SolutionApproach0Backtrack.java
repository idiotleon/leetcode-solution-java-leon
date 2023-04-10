/**
 * https://leetcode.com/problems/android-unlock-patterns/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/android-unlock-patterns/discuss/82464/Simple-and-concise-Java-solution-in-69ms
 */
package com.idiotleon.leetcode.lvl4.lc0351;

public class SolutionApproach0Backtrack {
    /**
     * the first dimension represents the start position,
     * the second dimension represents the end position,
     * and the value represents the number on the lock screen to be jumped upon.
     */
    private int[][] jumps;
    private boolean[] visited;
    
    public int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        
        int count = 0;
        count += backtrack(1, 1, 0, m, n) * 4;  // 1, 3, 7, 9 are symmetrical
        count += backtrack(2, 1, 0, m, n) * 4;  // 2, 4, 6, 8 are symmetrical
        count += backtrack(5, 1, 0, m, n);
        return count;
    }
    
    private int backtrack(int start, int len, int count, int m, int n){
        if(len >= m) count++;   // to only count moves that are larger than m
        len++;
        if(len > n) return count;   // to stop when moves hit n
        visited[start] = true;
        for(int next = 1; next <= 9; next++){
            int jump = jumps[start][next];
            /**
             * jump == 0, meaning "start" and "next" are contiguous
             * 
             * visited[jump] == true, meaning, to further backtrack, "next" originates from "jump"
             */
            if(!visited[next] && (jump == 0 || visited[jump])){
                count = backtrack(next, len, count, m, n);
            }
        }
        visited[start] = false; // backtrack
        return count;
    }
}