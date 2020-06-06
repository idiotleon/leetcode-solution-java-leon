/**
* https://leetcode.com/problems/isomorphic-strings/
*/
package com.zea7ot.lc.lvl2.lc0205;

public class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        
        return true;
    }
}