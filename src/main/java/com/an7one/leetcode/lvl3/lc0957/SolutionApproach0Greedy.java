/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * 
 * Time Complexity:     O(2 ^ N_CELLS)
 * 
 * Space Complexity:    O(N_CELLS)
 * 
 * References:
 *  https://leetcode.com/problems/prison-cells-after-n-days/discuss/205678/C%2B%2BJava-O(1)-memory-simulation-cycle
 */
package com.an7one.leetcode.lvl3.lc0957;

import java.util.Arrays;

public class SolutionApproach0Greedy {
    public int[] prisonAfterNDays(int[] cells, int N) {
        final int N_CELLS = cells.length;
        int[] firstAppearance = new int[N_CELLS];
        int[] nextCells = new int[N_CELLS];
        for(int cycle = 0; N-- > 0; cells = nextCells.clone(), ++cycle){
            for(int i = 1; i < N_CELLS - 1; i++){
                nextCells[i] = (cells[i - 1] == cells[i + 1] ? 1 : 0);
            }
            
            if(cycle == 0) firstAppearance = nextCells.clone();
            else if(Arrays.equals(firstAppearance, nextCells)) N %= cycle;
        }
        
        return cells;
    }
}