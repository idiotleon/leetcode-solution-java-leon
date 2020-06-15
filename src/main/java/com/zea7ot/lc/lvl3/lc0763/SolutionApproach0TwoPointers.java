/**
 * https://leetcode.com/problems/partition-labels/
 * 
 * Time Complexity:     2 * O(N) ~ O(N)
 * Space Complexity:    O(N), consumed by the answer array/list
 */
package com.zea7ot.lc.lvl3.lc0763;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0TwoPointers {
    public List<Integer> partitionLabels(String str) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(str == null || str.isEmpty()) return ans;
        
        final char[] CHS = str.toCharArray();
        final int L = str.length();

        int[] lastIndexes = new int[26];
        for(int i = 0; i < L; i++){
            // to record the last index of each char
            lastIndexes[CHS[i] - 'a'] = i;
        }
        
        // to record the end index of the current substring
        int last = 0, start = 0;
        for(int i = 0; i < L; i++){
            last = Math.max(last, lastIndexes[CHS[i] - 'a']);
            if(last == i){
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return ans;
    }
}