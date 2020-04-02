/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
package main.java.lcidiot.lc0953;

class Solution {
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

    public boolean isAlienSorted2(String[] words, String order) {
        int[] index = new int[26];
        for(int i = 0; i < order.length(); i++){
            index[order.charAt(i) - 'a'] = i;
        }
        
        search: for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            
            for(int k = 0; k < Math.min(word1.length(), word2.length()); ++k){
                if(word1.charAt(k) != word2.charAt(k)){
                    if(index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a']){
                        return false;
                    }
                    
                    continue search;
                }
                
                if(word1.length() > word2.length()) return false;
            }
        }
        
        return true;
    }
}