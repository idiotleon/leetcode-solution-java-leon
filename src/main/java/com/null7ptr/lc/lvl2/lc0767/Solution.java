/**
 * https://leetcode.com/problems/reorganize-string/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N + 26) ~ O(N)
 */
package com.null7ptr.lc.lvl2.lc0767;

public class Solution {
    public String reorganizeString(String S) {
        int[] hash = new int[26];
        final int L = S.length();
        
        int max = 0, idxMax = 0;
        for(int i = 0; i < L; i++){
            if(++hash[S.charAt(i) - 'a'] > (L + 1) / 2) return "";
            
            if(hash[S.charAt(i) - 'a'] > max){
                max = hash[S.charAt(i) - 'a'];
                idxMax = S.charAt(i) - 'a';
            }
        }
        
        char[] res = new char[L];
        int idx = 0;
        // to align the most frequent char(s)/letter(s) intermittently
        while(hash[idxMax] > 0){
            res[idx] = (char) ('a' + idxMax);
            idx += 2;
            hash[idxMax]--;
        }
        
        // to align the rest of letters intermittently
        for(int i = 0; i < 26; i++){
            while(hash[i] > 0){
                if(idx >= res.length){
                    idx = 1;
                }
                
                res[idx] = (char)(i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}