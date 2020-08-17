/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * 
 * Time Complexity: O()
 * Space Complexity: O(N * L)
 *  N, number of words
 *  L, length of words
 */
package com.zea7ot.leetcode.lvl4.lc0792;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach1 {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        List<List<StringBuilder>> waiting = new ArrayList<List<StringBuilder>>();
        
        for(int c = 0; c <= 26; c++){
            waiting.add(new ArrayList<StringBuilder>());
        }
        
        for(String word : words){
            waiting.get(word.charAt(0) - 'a').add(new StringBuilder(word));
        }
        
        for(char ch : S.toCharArray()){
            List<StringBuilder> advance = waiting.get(ch - 'a');
            
            waiting.set(ch - 'a', new ArrayList<StringBuilder>());
            
            for(StringBuilder builder : advance){
                builder.deleteCharAt(0);
                if(builder.length() != 0){
                    waiting.get(builder.charAt(0) - 'a').add(builder);
                }else{
                    ans++;
                }
            }
        }
        
        return ans;
    }
}