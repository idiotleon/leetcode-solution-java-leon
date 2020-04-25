/**
 * https://leetcode.com/problems/assign-cookies/
 * 
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(1)
 */
package com.null7ptr.lc.lvl1.lc0455;

import java.util.Arrays;

public class SolutionApproachGreedy {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int greed = 0, candy = 0;
        
        while(greed < g.length && candy < s.length){
            if(g[greed] > s[candy]){
                candy++;
            }else{
                greed++;
                candy++;
            }
        }
        
        return greed;
    }
}