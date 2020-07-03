/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * 
 * Time Complexity:     O(2 ^ N_CELLS)
 *  N_CELLS, number of cells, NOT days
 * 
 * Space Complexity:    O(N_CELLS) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14/259344
 *  https://leetcode.com/problems/prison-cells-after-n-days/discuss/205684/JavaPython-Find-the-Loop-or-Mod-14
 */
package com.zea7ot.lc.lvl3.lc0957;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<String, Integer>();
        while(N > 0){
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), N--);
            for(int i = 1; i < 7; i++){
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            if(seen.containsKey(Arrays.toString(cells))){
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        
        return cells;
    }
}