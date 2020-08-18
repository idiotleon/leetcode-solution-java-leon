/**
 * https://leetcode.com/problems/heaters/
 * 
 * Time Complexity: O(N(houses) * 2 * lg(N(houses))) ~ O(N(houses) * lg(N(houses)))
 * Space Complexity: O(N(heaters))
 * 
 * References:
 *  https://leetcode.com/problems/heaters/discuss/95928/Java-TreeSet-log(n)-Solution-with-explanation
 */
package com.zea7ot.leetcode.lvl2.lc0475;

import java.util.TreeSet;

public class SolutionApproach1TreeSet {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> treeset = new TreeSet<Integer>();
        for(int heater : heaters) treeset.add(heater);
        
        int ans = 0;
        for(int house : houses){
            Integer upper = treeset.ceiling(house);
            Integer lower = treeset.floor(house);
            ans = Math.max(ans, 
                           Math.min(upper == null ? Integer.MAX_VALUE : upper - house, lower == null ? Integer.MAX_VALUE : house - lower));
        }
        
        return ans;
    }
}