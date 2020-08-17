/**
 * https://leetcode.com/problems/find-the-town-judge/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl1.lc0997;

public class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        for(int[] t : trust){
            --count[t[0]];
            ++count[t[1]];
        }
        
        for(int i = 1; i <= N; i++){
            if(count[i] == N - 1)
                return i;
        }
        
        return -1;
    }
}