/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
package com.null7ptr.lc.lvl2.lc0953;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[order.length()];
        for(int i = 0; i < order.length(); i++){
            dict[order.charAt(i) - 'a'] = i;
        }
        
        for(int i = 1; i < words.length; i++){
            if(bigger(words[i - 1], words[i], dict)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean bigger(String word1, String word2, int[] dict){
        final int M = word1.length(), N = word2.length();
        
        for(int i = 0; i < Math.min(M, N); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                return dict[word1.charAt(i) - 'a'] > dict[word2.charAt(i) - 'a'];
            }
        }
        
        return M > N;
    }
}