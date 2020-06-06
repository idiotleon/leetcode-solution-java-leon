/**
 * https://leetcode.com/problems/kill-process/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.lc.lvl3.lc0582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproachTSort {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> ans = new ArrayList<Integer>();
        
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < pid.size(); i++){
            graph.putIfAbsent(ppid.get(i), new HashSet<Integer>());
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(kill);
        
        while(!queue.isEmpty()){
            int processId = queue.removeFirst();
            ans.add(processId);
            
            if(graph.containsKey(processId)){
                for(int process : graph.get(processId)){
                    queue.add(process);
                }
            }
        }
        
        return ans;
    }
}