/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * Time Complexity:     O(n * sqrt(n))
 * Space Complexity:    O(n)
 * 
 * References:
 *  https://leetcode.com/problems/perfect-squares/discuss/71488/Summary-of-4-different-solutions-(BFS-DP-static-DP-and-mathematics)
 */
package com.polyg7ot.lc.lvl3.lc0279;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DP1 {
    private static List<Integer> ans = new ArrayList<Integer>();
    
    public int numSquares(int n) {
        if(ans.isEmpty()) ans.add(0);
        
        while(ans.size() <= n){
            final int SIZE = ans.size();
            int tempMin = Integer.MAX_VALUE;
            for(int j = 1; j * j <= SIZE; j++){
                tempMin = Math.min(tempMin, ans.get(SIZE - j * j)  + 1);
            }
            ans.add(tempMin);
        }
        
        return ans.get(n);
    }
}