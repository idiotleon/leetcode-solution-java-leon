/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 * 
 * Time Complexity:     O(`NR`)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-distance-in-arrays/discuss/104613/Java-Solution-Min-and-Max/107384
 *  https://leetcode.com/problems/maximum-distance-in-arrays/discuss/104613/Java-Solution-Min-and-Max
 */
package com.an7one.leetcode.lvl3.lc0624;

import java.util.List;

public class SolutionApproach0LinearScan {
    public int maxDistance(List<List<Integer>> arrays) {
        // sanity check
        if(arrays.isEmpty()) return 0;
        final int NR = arrays.size();
        
        int longest = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for(int i = 1; i < NR; ++i){
            List<Integer> array = arrays.get(i);
            final int NC = array.size();
            
            longest = Math.max(longest, array.get(NC - 1) - min);
            longest = Math.max(longest, max - array.get(0));
            
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(NC - 1));            
        }
        
        return longest;
    }
}
