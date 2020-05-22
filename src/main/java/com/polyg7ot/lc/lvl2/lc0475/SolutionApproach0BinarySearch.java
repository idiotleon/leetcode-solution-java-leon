/**
 * https://leetcode.com/problems/heaters/
 * 
 * Time Complexity: O(max(N * lg(N), O(M * lg(N))))
 *  M, length of houses
 *  N, length of heaters
 * 
 * References:  
 *  https://leetcode.com/problems/heaters/discuss/95886/Short-and-Clean-Java-Binary-Search-Solution/198231
 *  https://leetcode.com/problems/heaters/discuss/95886/Short-and-Clean-Java-Binary-Search-Solution
 */
package com.polyg7ot.lc.lvl2.lc0475;

import java.util.Arrays;

public class SolutionApproach0BinarySearch {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || heaters == null) return Integer.MAX_VALUE;
        
        Arrays.sort(heaters);
        
        int ans = Integer.MIN_VALUE;
        for(int house : houses){
            int rad = findRadius(house, heaters);
            ans = Math.max(ans, rad);
        }
        
        return ans;
    }
    
    private int findRadius(int house, int[] heaters){
        int start = 0, end = heaters.length - 1;
    
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int heater = heaters[mid];
            
            if(heater == house) return 0;
            else if(heater > house){
                right = heater - house;
                end = mid - 1;
            }else{
                left = house - heater;
                start = mid + 1;
            }
        }
        
        return Math.min(left, right);
    }
}