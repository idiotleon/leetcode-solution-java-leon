/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) for processing, O(N) for the answer
 * 
 * References:
 *  https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/discuss/328920/very-easy-and-clean-code-one-pass-O(N)-with-explanation
 *  https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/discuss/329007/Help-me-understand-the-problem-Maximum-Nesting-Depth-of-Two-Valid-Parentheses-Strings/301828
 */
package com.polyg7ot.lc.lvl3.lc1111;

public class SolutionApproach0OnePass {
    public int[] maxDepthAfterSplit(String seq) {
        final int L = seq.length();
        int[] ans = new int[L];
        int level = 0, idx = 0;
        while(idx < L){
            if(seq.charAt(idx) == '('){
                ans[idx] = ++level % 2;
            }else{
                ans[idx] = level-- % 2;
            }
            
            idx++;
        }
        
        return ans;
    }
}