/**
 * https://leetcode.com/problems/find-the-celebrity/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass/189358
 *  https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass
 */
package com.zea7ot.leetcode.lvl3.lc0277;

public class SolutionApproach0DFS1 {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(FakeAPI.knows(candidate, i)){
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i < candidate && FakeAPI.knows(candidate, i) || !FakeAPI.knows(i, candidate)) return -1;
            if(i > candidate && !FakeAPI.knows(i, candidate)) return -1;
        }
        
        return candidate;
    }
}