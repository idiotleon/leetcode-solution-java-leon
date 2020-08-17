/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 * 
 * Time Complexity: O(N * LEN(str) * lg(LEN(word)))
 * Space Complexity: O(LEN(str))
 * 
 * References:
 *  https://leetcode.com/problems/number-of-matching-subsequences/discuss/117602/JAVA-binary-search
 */
package com.zea7ot.leetcode.lvl4.lc0792;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BinarySearch {
    public int numMatchingSubseq(String str, String[] words) {
        List<List<Integer>> indexes = getIndexes(str);
        
        int ans = 0;
        outer: for(String word : words){
            int idx = -1;
            for(char ch : word.toCharArray()){
                idx = binarySearch(indexes.get(ch - 'a'), idx);
                if(idx == -1) continue outer;
            }
            
            ans++;
        }
        
        return ans;
    }
    
    private List<List<Integer>> getIndexes(String str){
        List<List<Integer>> indexes = new ArrayList<List<Integer>>();
        for(int i = 0; i < 26; i++){
            indexes.add(new ArrayList<Integer>());
        }
        
        char[] chs = str.toCharArray();
        for(int i = 0; i < chs.length; i++){
            indexes.get(chs[i] - 'a').add(i);
        }
        
        return indexes;
    }
    
    /**
     * This binarySearch actually provides the lower bound (of the targeted index)
     * 
     * @param indexes   the indexes list built by str(input)
     * @param idx       the targeted index
     * @return          the lower bound of targeted index
     */
    private int binarySearch(List<Integer> indexes, int idx){
        if(indexes == null) return -1;
        
        int low = 0, high = indexes.size();
        while(low < high){
            int mid = low + (high - low) / 2;
            // please pay twice attention to the equality conditions here
            // "if(idx == indexes.get(mid)) return mid;" is considered wrong
            // well this is correct: "if(idx == indexes.get(mid)) return mid - 1;"
            if(idx < indexes.get(mid)) high = mid;
            else low = mid + 1;
        }
        
        return low == indexes.size() ? -1 : indexes.get(low);
    }
}