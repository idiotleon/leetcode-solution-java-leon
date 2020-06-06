/**
 * https://leetcode.com/problems/heaters/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/heaters/discuss/95881/Simple-Java-Solution-with-2-Pointers
 */
package com.zea7ot.lc.lvl2.lc0475;

import java.util.Arrays;

public class SolutionApproach0TwoPtrs {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, j = 0, ans = 0;
        while(i < houses.length){
            while(j < heaters.length - 1
                  && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) 
                  j++;
            
            ans = Math.max(ans, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return ans;
    }
}