/**
 * https://leetcode.com/problems/word-subsets/
 * 
 * Time Complexity:     O(LEN(A) + LEN(B))
 * Space Complexity:    O(LEN(A) + LEN(B))
 * 
 * References:
 *  https://leetcode.com/problems/word-subsets/discuss/175950/Easy-Java-Solution-Preprocess-Array-B
 */
package com.idiotleon.leetcode.lvl4.lc0916;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0PreprocessingB {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] freq = new int[26];
        for(String strB : B){
            int[] freqB = getFreq(strB);
            for(int i = 0; i < 26; i++){
                freq[i] = Math.max(freq[i], freqB[i]);
            }
        }
        
        List<String> ans = new ArrayList<String>();
        for(String strA : A){
            int[] freqA = getFreq(strA);
            int count = 0;
            for(int i = 0; i < 26; i++){
                if(freq[i] <= freqA[i]){
                    count++;
                }
            }
            
            if(count == 26) ans.add(strA);
        }
        return ans;
    }
    
    private int[] getFreq(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray())
            ++freq[ch - 'a'];
        return freq;
    }
}