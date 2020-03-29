/**
 * https://leetcode.com/problems/isomorphic-strings/
 */
package main.java.lcidiot.lc0205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
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

    public boolean isIsomorphic2(String s, String t) {
        int[] m = new int[512];
        for(int i = 0; i < s.length(); i++){
            if(m[s.charAt(i)] != m[t.charAt(i) + 256]) return false;
            m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
        }
        
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        
        Map<Character, Character> mapped = new HashMap<Character, Character>();
        Set<Character> seen = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if(mapped.containsKey(ch1)){
                if(mapped.get(ch1) != ch2){
                    return false;
                }
            }else{
                if(seen.contains(ch2)){
                    return false;
                }
                mapped.put(ch1, ch2);
                seen.add(ch2);
            }
        }
        
        return true;
    }
}