/**
 * https://leetcode.com/problems/longest-string-chain/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N * (L ^ 2))
 *  O(N * lg(N)), consumed by sorting the words(String[])
 *  O(N * (L ^ 2)), consumed by later checking.
 *      Please be noted that the operation "builder.deleteCharAt(i)"" is considered as O(L)
 * 
 * Space Complexity:    O(N) + O(N * L)
 * 
 * to [Bottom-up] DP
 * 
 * References:
 *  https://leetcode.com/problems/longest-string-chain/discuss/458069/JAVA-Easy-Solution-with-Explanation-(MUST-READ)!
 */
package com.zea7ot.lc.lvl3.lc1048;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DP {
    public int longestStrChain(String[] words) {
        // sanity check 
        if(words == null || words.length == 0) return 0;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<String, Integer>();
        
        int ans = 0;
        for(String word : words){
            if(dp.containsKey(word)) continue;
            dp.put(word, 1);
            for(int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                String previous = builder.deleteCharAt(i).toString();
                if(dp.containsKey(previous)
                    // this comparison is trivial,
                    // withouth which this test case, ["fha","fgha","egha","efha","efgh","efgha"], fails
                    && dp.get(previous) + 1 > dp.get(word)){
                    dp.put(word, dp.get(previous) + 1);
                }
            }
            
            ans = Math.max(ans, dp.get(word));
        }
        
        return ans;
    }
}