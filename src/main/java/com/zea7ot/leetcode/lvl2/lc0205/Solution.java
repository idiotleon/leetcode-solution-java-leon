/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
package com.zea7ot.leetcode.lvl2.lc0205;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256], m2 = new int[256];
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        
        return true;
    }
}