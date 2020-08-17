/**
 * https://leetcode.com/problems/binary-watch/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/binary-watch/discuss/88456/3ms-Java-Solution-Using-Backtracking-and-Idea-of-"Permutation-and-Combination"/93308
 */
package com.zea7ot.leetcode.lvl3.lc0401;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(num < 0) return ans;

        final int[] HOURS = {1, 2, 4, 8}, MINUTES = new int[]{1, 2, 4, 8, 16, 32};

        // pruning: HOURS, as candidates, only has 4 elements
        for(int pick = 0; pick <= Math.min(4, num); pick++){
            // purning: MINUTES, as candidates, only has 6 elements
            if(num - pick > 6) continue;
            List<Integer> minutesCombinations = new ArrayList<Integer>(),
                            hoursCombinations = new ArrayList<Integer>();

            backtrack(HOURS, pick, 1, 0, 0, hoursCombinations, 12);
            backtrack(MINUTES, num - pick, 1, 0, 0, minutesCombinations, 60);
            
            for(int hour : hoursCombinations){
                for(int minute : minutesCombinations){
                    if(minute < 10) ans.add(hour + ":0" + minute);
                    else ans.add(hour + ":" + minute);
                }
            }
        }
        return ans;
    }
    
    private void backtrack(final int[] CANDIDATES, 
                           final int AT_MOST_PICKS, 
                           int picked, 
                           int curTime, 
                           int start, 
                           List<Integer> res, 
                           final int LIMIT){
        
        if(picked > AT_MOST_PICKS){
            res.add(curTime);
            return;
        }
        
        for(int pick = start; pick < CANDIDATES.length; pick++){
            curTime += CANDIDATES[pick];
            if(curTime < LIMIT){
                backtrack(CANDIDATES, AT_MOST_PICKS, picked + 1, curTime, pick + 1, res, LIMIT);
            }
            // ? why is this necessary here?!
            curTime -= CANDIDATES[pick];
        }
    }
}