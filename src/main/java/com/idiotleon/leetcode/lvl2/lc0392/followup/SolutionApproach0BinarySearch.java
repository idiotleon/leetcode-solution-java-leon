/**
 * https://leetcode.com/problems/is-subsequence/
 * 
 * Time Complexity: O(LEN_S & lg(LEN_T))
 * Space Complexity: O(LEN_T)
 * 
 * Refences:
 *  https://leetcode.com/problems/is-subsequence/discuss/87321/Java-code-for-the-problem-(two-pointer)-and-the-follow-up-(Binary-Search)
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/number-of-matching-subsequences/
 */
package com.idiotleon.leetcode.lvl2.lc0392.followup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0BinarySearch {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> idxMap = new HashMap<Character, List<Integer>>();
        for(int i = 0; i < t.length(); i++){
            if(!idxMap.containsKey(t.charAt(i))){
                idxMap.put(t.charAt(i), new ArrayList<Integer>());
            }
            idxMap.get(t.charAt(i)).add(i);
        }
        
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            int nextIdx = getNextIdx(idxMap.get(ch), index);
            if(nextIdx < 0) return false;
            index = nextIdx;
        }
        
        return true;
    }
    
    private int getNextIdx(List<Integer> idxes, int index){
        if(idxes == null) return -1;
        int left = 0, right = idxes.size() - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(idxes.get(mid) <= index) left = mid + 1;
            else right = mid;
        }
        
        return idxes.get(left) > index ? idxes.get(left) : -1;
    }
}