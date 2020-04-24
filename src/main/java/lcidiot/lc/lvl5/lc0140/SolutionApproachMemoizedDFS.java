/**
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Time complexity : O(n^3). Size of recursion tree can go up to n^2. The creation of list takes nn time.
 * Space complexity : O(n^3). The depth of the recursion tree can go up to nn and each activation record can contains a string list of size nn.
 */
package main.java.lcidiot.lc.lvl5.lc0140;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class SolutionApproachMemorizedDFS {
    private HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();

    public List<String> wordBreak(String str, List<String> wordDict) {
        return wordBreak(str, new HashSet<String>(wordDict), 0);
    }
    
    private List<String> wordBreak(String str, Set<String> wordDict, int start){
        if(map.containsKey(start)) return map.get(start);
        
        LinkedList<String> res = new LinkedList<String>();
        if(start == str.length()) res.add("");
        
        for(int end = start + 1; end <= str.length(); end++){
            if(wordDict.contains(str.substring(start, end))){
                List<String> lists = wordBreak(str, wordDict, end);
                for(String list : lists){
                    res.add(str.substring(start, end) + (list.equals("") ? "": " ") + list);
                }
            }
        }
        
        map.put(start, res);
        return res;
    }
}