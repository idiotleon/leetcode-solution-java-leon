/**
 * https://leetcode.com/problems/jewels-and-stones/
 * 
 * Time Complexity: O(Nlg(N)), sorting costs the most
 * Space Complexity: O(N), creating 2 corresponding char arrays
 */
 package com.an7one.leetcode.lvl1.lc0771;

import java.util.Arrays;

public class SolutionApproachTwoPtrs {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.isEmpty() || S == null || S.isEmpty()) return 0;
        
        final int LEN_J = J.length(), LEN_S = S.length();
        char[] jarr = J.toCharArray(), sarr = S.toCharArray();
        Arrays.sort(jarr);
        Arrays.sort(sarr);
        
        int ptrj = 0, ptrs = 0;
        int count = 0;
        
        while(ptrj < LEN_J){
            while(jarr[ptrj] > sarr[ptrs]){
                ptrs++;
                if(ptrs == LEN_S) return count;
            }
            
            while(jarr[ptrj] == sarr[ptrs]){
                count++;
                ptrs++;
                if(ptrs == LEN_S) return count;
            }
                            
            ptrj++;
        }
        
        return count;
    }
}