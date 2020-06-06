/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * Here the pair is to mark a range for the substring is a palindrome. 
 * If pair[i][j] is true, that means sub string from i to j is palindrome.
 * 
 * The ans[i], is to store from beginng until current index i (Non inclusive), all possible partitions. 
 * From the past "ans" we can determine current "ans".
 */
package com.zea7ot.lc.lvl3.lc0131;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DP {
    public List<List<String>> partition(String s) {
        final int L = s.length();
        List<List<List<String>>> ans = new ArrayList<List<List<String>>>(L + 1);
        for(int i = 0; i < L + 1; i++) ans.add(new ArrayList<List<String>>());
        // this cannot be skipped, otherwise the DP process will NOT be started
        ans.get(0).add(new ArrayList<String>());
        
        boolean[][] pair = new boolean[L][L];
        for(int i = 0; i < L; i++){
            for(int left = 0; left <= i; left++){
                if(s.charAt(left) == s.charAt(i) 
                   && (i - left <= 1 || pair[left + 1][i - 1])){
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for(List<String> r : ans.get(left)){
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        ans.get(i + 1).add(ri);
                    }
                }
            }
        }
        
        return ans.get(L);
    }
}