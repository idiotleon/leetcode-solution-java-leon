/**
 * https://leetcode.com/problems/counting-bits/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/counting-bits/discuss/657040/Java-O(n)-solution-3-lines-DP-with-explanation
 */
package com.polyg7ot.lc.lvl3.lc0338;

public class SolutionApproach0DP {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        
        for(int i = 1; i < ans.length; i++){
            ans[i] = (i % 2 == 1) ? ans[i - 1] + 1 : ans[i / 2];
        }
        
        return ans;
    }
}