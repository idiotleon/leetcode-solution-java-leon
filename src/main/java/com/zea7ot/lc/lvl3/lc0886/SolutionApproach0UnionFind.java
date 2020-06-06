/**
 * https://leetcode.com/problems/possible-bipartition/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/possible-bipartition/discuss/195303/Java-Union-Find
 */
package com.zea7ot.lc.lvl3.lc0886;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0UnionFind {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] roots = new int[N + 1];
        for(int i = 0; i <= N; i++) roots[i] = i;
        
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for(int[] dislike : dislikes){
            int u = dislike[0], v = dislike[1];
            graph.putIfAbsent(u, new ArrayList<Integer>());
            graph.putIfAbsent(v, new ArrayList<Integer>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        for(int i = 1; i <= N; i++){
            if(graph.containsKey(i)){
                int root1 = find(roots, i);
                List<Integer> opponents = graph.get(i);
                int root2 = find(roots, opponents.get(0));
                if(root1 == root2) return false;
                for(int j = 1; j < opponents.size(); j++){
                    int rootOppo = find(roots, opponents.get(j));
                    if(root1 == rootOppo) return false;
                    roots[rootOppo] = root2;
                }
            }
        }
        
        return true;
    }
    
    private int find(int[] roots, int i){
        while(i != roots[i]){
            i = roots[roots[i]];
        }
        
        return i;
    }
}