/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(2 * N) ~ O(N)
 */
package com.zea7ot.lc.lvl3.lc1209;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachStack {
    public String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder();
        List<Integer> counts = new ArrayList<Integer>();
        
        for(int i = 0; i < s.length(); i++){
            if(counts.isEmpty()){
                builder.append(s.charAt(i));
                counts.add(1);
            }else{
                if(builder.charAt(builder.length() - 1) == s.charAt(i)){
                    counts.add(counts.get(counts.size() - 1) + 1);
                }else{
                    counts.add(1);
                }
                builder.append(s.charAt(i));
            }
            
            // to remove the last k elements
            if(counts.get(counts.size() - 1) == k){
                int cnt = k;
                while(cnt-- > 0){
                    builder.deleteCharAt(builder.length() - 1);
                    counts.remove(counts.size() - 1);
                }
            }
        }
        
        return builder.toString();
    }
}