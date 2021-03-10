/**
 * https://leetcode.com/problems/jewels-and-stones/
 * 
 * Time Complexity: O(J + S)
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl1.lc0771;

public class SolutionApproachDictArr {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.isEmpty() || S == null || S.isEmpty()) return 0;
        
        int[] dict = new int[128];
        
        for(int i = 0; i < J.length(); i++){
            ++dict[J.charAt(i)];
        }
        
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(dict[S.charAt(i)] > 0){
                count++;
            }
        }
        return count;
    }
}