/**
 * https://leetcode.com/problems/analyze-user-website-visit-pattern/
 * 
 * Time Complexity:     O(N ^ 3)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/analyze-user-website-visit-pattern/discuss/355606/Java-Very-Easy-Understand-With-Explanation
 */
package com.zea7ot.lc.lvl4.lc1152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0BrutalForce {
       public List<String> mostVisitedPattern(String[] username, 
                                           int[] timestamp, 
                                           String[] website) {
        final int N = username.length;
        Map<String, List<Pair>> map = new HashMap<String, List<Pair>>();
        for(int i = 0; i < N; i++){
            map.putIfAbsent(username[i], new ArrayList<Pair>());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        Map<String, Integer> count = new HashMap<String, Integer>();
        String res = "";
        for(Map.Entry<String, List<Pair>> entry : map.entrySet()){
            List<Pair> list = entry.getValue();
            if(list.size() < 3) continue;
            Set<String> seen = new HashSet<String>();
            Collections.sort(list, (a, b) -> Integer.compare(a.time, b.time));
            
            final int SIZE = list.size();
            for(int i = 0; i < SIZE; i++){
                for(int j = i + 1; j < SIZE; j++){
                    for(int k = j + 1; k < SIZE; k++){
                        String str = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if (!seen.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            seen.add(str);
                        }
                        
                        if (res.isEmpty()
                            || count.get(res) < count.get(str) 
                            || (count.get(res) == count.get(str) && res.compareTo(str) > 0)) {
                            res = str;
                        }
                    }
                }
            }
        }
        
        return Arrays.asList(res.split(" "));
    }
    
    private class Pair{
        protected int time;
        protected String web;
        protected Pair(int time, String web){
            this.time = time;
            this.web = web;
        }
    }
}