/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Here the pair is to mark a range for the substring is a palindrome. 
 * If pair[i][j] is true, that means sub string from i to j is palindrome.
 * 
 * The ans[i], is to store from beginng until current index i (Non inclusive), all possible partitions. 
 * From the past "ans" we can determine current "ans".
 */
package com.polyg7ot.lc.lvl3.lc0131;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproachDP {
    public List<List<String>> partition(String s) {
        final int L = s.length();
        List<List<String>>[] ans = new List[L + 1];
        ans[0] = new ArrayList<List<String>>();
        ans[0].add(new ArrayList<String>());
        
        boolean[][] pair = new boolean[L][L];
        for(int i = 0; i < s.length(); i++){
            ans[i + 1] = new ArrayList<List<String>>();
            for(int left = 0; left <= i; left++){
                if(s.charAt(left) == s.charAt(i) 
                   && (i - left <= 1 || pair[left + 1][i - 1])){
                    pair[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for(List<String> r : ans[left]){
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        ans[i + 1].add(ri);
                    }
                }
            }
        }
        
        return ans[L];
    }
}