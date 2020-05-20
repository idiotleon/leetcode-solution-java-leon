/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N) for the answer, O(1) for processing
 * 
 * References:
 *  https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/discuss/328841/JavaC%2B%2BPython-O(1)-Extra-Space-Except-Output
 */
package com.polyg7ot.lc.lvl3.lc1111;

public class SolutionApproach1OnePass {
    public int[] maxDepthAfterSplit(String seq) {
        final int L = seq.length();
        int[] ans = new int[L];
        for(int i = 0; i < L; i++){
            ans[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        }
        
        return ans;
    }
}