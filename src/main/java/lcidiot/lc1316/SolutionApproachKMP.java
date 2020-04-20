/**
 * https://leetcode.com/problems/distinct-echo-substrings/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package main.java.lcidiot.lc1316;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproachKMP {
    public int distinctEchoSubstrings(String text) {
        if(text == null || text.isEmpty()) return 0;
        
        final int L = text.length();
        Set<String> set = new HashSet<String>();
        
        for(int s = 0; s < L; s++){
            int[] kmpTable = new int[L];
            int i = 1, j = 0;
            while(s + i < L){
                if(text.charAt(s + i) == text.charAt(s + j)){
                    kmpTable[i++] = ++j;
                    
                    // must be even length
                    if(i % 2 == 1) continue;
                    // if duplicate as half, 
                    // the remaining prefix length must be
                    // divisible to total length
                    if((i / 2) % (i - j) == 0){
                        set.add(text.substring(s, s + i));
                    }
                }else if(j == 0){
                    i++;
                }else{
                    j = kmpTable[j - 1];
                }
            }
        }
        
        return set.size();
    }
}