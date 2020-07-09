/**
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Time complexity :    O(N ^ 3). 
 *  Size of recursion tree can go up to (N ^ 2). 
 *  The creation of list takes (N ^ 2) time.
 * 
 * Space complexity :   O(N ^ 3). 
 *  The depth of the recursion tree can go up to (N ^ 2),
 *  and each activation record can contains a string list of size (N ^ 2).
 */
package com.zea7ot.lc.lvl5.lc0140;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFSMemo {
    public List<String> wordBreak(String str, List<String> wordDict) {
        Map<Integer, List<String>> memo = new HashMap<Integer, List<String>>();
        Set<String> wordSet = new HashSet<String>(wordDict);
        return wordBreak(str, wordSet, 0, memo);
    }
    
    private List<String> wordBreak(String str, 
                                   Set<String> wordSet, 
                                   int start, 
                                   Map<Integer, List<String>> memo){
        if(memo.containsKey(start)) return memo.get(start);
        List<String> res = new LinkedList<String>();
        final int L = str.length();
        if(start == L) res.add("");
        
        for(int end = start + 1; end <= L; end++){
            String sub = str.substring(start, end);
            if(!wordSet.contains(sub)) continue;
            List<String> lists = wordBreak(str, wordSet, end, memo);
            for(String list : lists){
                res.add(sub + (list.equals("") ? "" : " ") + list);
            }
        }
        
        memo.put(start, res);
        return res;
    }
}