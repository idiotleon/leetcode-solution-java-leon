/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 */
package com.polyg7ot.lc.lvl3.lc1353;

import java.util.Arrays;

public class SolutionApproachGreedy {
    public int maxEvents(int[][] events) {
        // sanity check
        if(events == null || events.length == 0) return 0;
        
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[1], e2[1]));
        
        int ans = 0;
        
        boolean[] seen = new boolean[100001];
        for(int[] event : events){
            for(int i = event[0]; i <= event[1]; i++){
                if(seen[i]) continue;
                seen[i] = true;
                ++ans;
                break;
            }
        }
        
        return ans;
    }
}