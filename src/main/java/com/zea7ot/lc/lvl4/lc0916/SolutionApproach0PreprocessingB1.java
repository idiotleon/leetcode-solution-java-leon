/**
 * https://leetcode.com/problems/word-subsets/
 * 
 * Time Complexity:     O(LEN(A) + LEN(B))
 * Space Complexity:    O(LEN(A) + LEN(B))
 * 
 * References:
 *  https://leetcode.com/problems/word-subsets/discuss/175850/JavaPython-3-Time-O(A-%2B-B)-clean-codes-count-the-most-frequent-char-of-words-in-B
 */
package com.zea7ot.lc.lvl4.lc0916;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0PreprocessingB1 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] freq = new int[26];
        for(String strB : B){
            int[] freqB = new int[26];
            for(char ch : strB.toCharArray()) ++freqB[ch - 'a'];
            for(int i = 0; i < 26; i++)
                freq[i] = Math.max(freq[i], freqB[i]);
        }
        
        List<String> ans = new ArrayList<String>();
        outer: for(String strA : A){
            int[] freqA = new int[26];
            for(char ch : strA.toCharArray()) ++freqA[ch - 'a'];
            for(int i = 0; i < 26; i++){
                if(freq[i] > freqA[i]){
                    continue outer;
                }
            }
            ans.add(strA);
        }
        
        return ans;
    }
}