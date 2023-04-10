/**
 * https://leetcode.com/problems/next-closest-time/
 * 
 * Time Complexity:     O(4 ^ 4)
 * Space Complexity:    O(4 ^ 4)
 * 
 * References:
 *  https://leetcode.com/problems/next-closest-time/discuss/107788/Verbose-Java-solution-DFS/110001
 */
package com.idiotleon.leetcode.lvl3.lc0681;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach1Sorting {
    public String nextClosestTime(String time) {
        char[] chs = time.toCharArray();
        char[] digits = {chs[0], chs[1], chs[3], chs[4]};
        
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < 4; ++i)
            for(int j = 0; j < 4; ++j)
                for(int k = 0; k < 4; ++k)
                    for(int l = 0; l < 4; ++l){
                        StringBuilder builder = new StringBuilder();
                        builder.append(digits[i]).append(digits[j]).append(':').append(digits[k]).append(digits[l]);
                        if(isValidTime(builder.toString()))
                            set.add(builder.toString());
                    }
        
        List<String> allTimes = new ArrayList<String>();
        allTimes.addAll(set);
        Collections.sort(allTimes);
        int idx = allTimes.indexOf(time);
        return idx == allTimes.size() - 1 ? allTimes.get(0) : allTimes.get(idx + 1);
    }
    
    private boolean isValidTime(String time){
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
}