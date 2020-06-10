/**
 * https://leetcode.com/problems/palindrome-permutation-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.lc.lvl4.lc0267;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    private static final char IMPOSSIBLE = '#';
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(s == null || s.isEmpty()) return new ArrayList<String>();
        
        int[] freq = new int[128];
        for(char c : s.toCharArray()){
            ++freq[c];
        }
        
        StringBuilder candidates = new StringBuilder();
        
        int oddCount = 0;
        char oddChar = IMPOSSIBLE;   // impossible char
        for(int i = 0; i < 128; i++){
            if(freq[i] % 2 == 1){
                oddCount++;
                oddChar = (char) i;
            }
            
            int cnt = freq[i] / 2;
            while(cnt-- > 0){
                candidates.append((char) i);
            }
        }
        
        // cannot tolerate more than one char of odd number
        if(oddCount > 1) return ans;
        
        backtrack(candidates.toString().toCharArray(), 
                  new boolean[candidates.length()], 
                  new StringBuilder(), 
                  ans, 
                  oddChar);
        
        return ans;
    }
    
    private void backtrack(char[] chs, 
                           boolean[] visited, 
                           StringBuilder path, 
                           List<String> paths,
                           final char ODD_CHAR){
        
        if(path.length() == chs.length){
            if(ODD_CHAR != IMPOSSIBLE){
                paths.add(new StringBuilder(path).append(ODD_CHAR).append(new StringBuilder(path).reverse()).toString());
            }else{
                paths.add(new StringBuilder(path).append(new StringBuilder(path).reverse()).toString());
            }
            return;
        }
        
        for(int i = 0; i < chs.length; i++){
            if(visited[i]) continue;
            if(i > 0 && chs[i - 1] == chs[i] && !visited[i - 1]) continue;
            visited[i] = true;
            path.append(chs[i]);
            backtrack(chs, visited, path, paths, ODD_CHAR);
            visited[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}