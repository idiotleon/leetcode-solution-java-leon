/**
 * https://leetcode.com/problems/assign-cookies/
 * 
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl1.lc0455;

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

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int candy = 0, greed = 0;
        
        while(greed < g.length && candy < s.length){
            // only greed can be satisfied, greed can move forward
            if(s[candy] >= g[greed]){
                greed++;
            }
            
            
            // no matter whether greed can be satisfied,
            // candy should move forward
            candy++;
         }
        
        return greed;
    }
}