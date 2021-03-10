/**
 * 
 */
package com.an7one.leetcode.lvl4.lc0068;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DP {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<String>();
        // sanity check
        if(words == null || words.length == 0 || maxWidth <= 0) return lines;
        
        final int L = words.length;
        int idx = 0;
        while(idx < L){
            int count = words[idx].length();
            int last = idx + 1;
            while(last < L){
                if(words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                ++last;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - idx - 1;
            
            if(last == L || diff == 0){
                for(int i = idx; i < last; i++) builder.append(words[i] + " ");
                builder.deleteCharAt(builder.length() - 1);
                for(int i = builder.length(); i < maxWidth; i++) builder.append(" ");
            }
            else{
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for(int i = idx; i < last; i++){
                    builder.append(words[i]);
                    if(i < last - 1){
                        for(int j = 0; j <= (spaces + ((i - idx) < r ? 1 : 0)); j++){
                            builder.append(" ");
                        }
                    }
                }
            }
            
            lines.add(builder.toString());
            idx = last;
        }
        
        return lines;
    }
}