/**
 * https://leetcode.com/problems/loud-and-rich/
 * 
 * Time Complexity: O(V + E) ~ O(N + richer.length)
 * Space Complexity: O(V + E) ~ O(N + richer.length)
 */
package com.polyg7ot.lc.lvl3.lc0851;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SolutionApproachTSort {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        final int N = quiet.length;
        int[] ans = new int[N];
        List<Set<Integer>> map = new ArrayList<Set<Integer>>();
        for(int i = 0; i < N; i++){
            ans[i] = i;
            map.add(i, new HashSet<Integer>());
        }
        
        int[] count = new int[N];
        for(int[] rich : richer){
            map.get(rich[0]).add(rich[1]);
            ++count[rich[1]];
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < N; i++){
            if(count[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int cur = queue.removeFirst();
            
            if(quiet[cur] < quiet[ans[cur]]){
                ans[cur] = cur;
            }
            
            for(int next : map.get(cur)){
                // since values of next has not touched yet,
                // it is better to update values of next with values of cur
                if(quiet[ans[next]] > quiet[ans[cur]]){
                    ans[next] = ans[cur];
                }
                
                if(--count[next] == 0){
                    queue.add(next);
                }
            }
        }
        
        return ans;
    }
}