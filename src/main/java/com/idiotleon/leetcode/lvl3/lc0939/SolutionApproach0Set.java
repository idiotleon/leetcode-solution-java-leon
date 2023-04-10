/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/minimum-area-rectangle/discuss/192025/Java-N2-Hashmap/235982
 */
package com.idiotleon.leetcode.lvl3.lc0939;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public int minAreaRect(int[][] points) {
        // sanity check
        if(points == null || points.length == 0) return 0;
        
        final int N = points.length;
        Set<String> set = new HashSet<String>();
        for(int[] point : points)
            set.add(point[0] + "#" + point[1]);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; ++i){
            for(int j = i + 1; j < N; ++j){
                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]) continue;
                String p1 = points[i][0] + "#" + points[j][1];
                String p2 = points[j][0] + "#" + points[i][1];
                if(set.contains(p1) && set.contains(p2)){
                    int area = Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1]));
                    min = Math.min(min, area);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}