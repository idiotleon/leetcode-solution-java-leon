/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) for processing, O(N) for the answer
 * 
 * References:
 *  https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/discuss/328841/JavaC%2B%2BPython-O(1)-Extra-Space-Except-Output
 */
package com.an7one.leetcode.lvl3.lc1111;

public class SolutionApproach1OnePass1 {
    public int[] maxDepthAfterSplit(String seq) {
        final int L = seq.length();
        int counterA = 0, counterB = 0;
        int[] ans = new int[L];
        
        for(int i = 0; i < L; i++){
            if(seq.charAt(i) == '('){
                if(counterA < counterB){
                    ++counterA;
                }else{
                    ++counterB;
                    ans[i] = 1;
                }
            }else{
                if(counterA > counterB){
                    --counterA;
                }else{
                    --counterB;
                    ans[i] = 1;
                }
            }
        }
        
        return ans;
    }
}