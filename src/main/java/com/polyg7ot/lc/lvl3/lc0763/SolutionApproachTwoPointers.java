/**
 * https://leetcode.com/problems/partition-labels/
 * 
 * Time Complexity: 2 * O(N)
 * Space Complexity: O(1)
 */
package com.polyg7ot.lc.lvl3.lc0763;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachTwoPointers {
    public List<Integer> partitionLabels(String str) {
        List<Integer> ans = new ArrayList<Integer>();
        if(str == null || str.length() == 0) return ans;
        
        int[] lastIndex = new int[26];
        for(int i = 0; i < str.length(); i++){
            // to record the last index of each char
            lastIndex[str.charAt(i) - 'a'] = i;
        }
        
        // to record the end index of the current substring
        int last = 0, start = 0;
        for(int i = 0; i < str.length(); i++){
            last = Math.max(last, lastIndex[str.charAt(i) - 'a']);
            if(last == i){
                ans.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return ans;
    }
}