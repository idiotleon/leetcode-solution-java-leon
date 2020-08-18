/**
 * https://leetcode.com/problems/validate-stack-sequences/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0946;

public class SolutionApproachStack1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for(int num : pushed){
            pushed[i++] = num;
            while(i > 0 && pushed[i - 1] == popped[j]){
                --i;
                ++j;
            }
        }
        
        return i == 0;
    }
}