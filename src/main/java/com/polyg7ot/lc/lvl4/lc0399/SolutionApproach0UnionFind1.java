/**
 * https://leetcode.com/problems/evaluate-division/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 */
package com.polyg7ot.lc.lvl4.lc0399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0UnionFind1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, String> roots = new HashMap<String, String>();
        Map<String, Double> ratios = new HashMap<String, Double>();
        
        for(int i = 0; i < equations.size(); i++){
            union(roots, ratios, equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        double[] ans = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            String start = queries.get(i).get(0), end = queries.get(i).get(1);
            if(!roots.containsKey(start) 
               || !roots.containsKey(end)
               || !(find(roots, ratios, start)).equals(find(roots, ratios, end))){
                ans[i] = -1.0;
            }else{
                ans[i] = ratios.get(start) / ratios.get(end);
            }
        }
        
        return ans;
    }
    
    private void union(Map<String, String> roots, 
                       Map<String, Double> ratios, 
                       String start, 
                       String end, 
                       double val){
        
        if(!roots.containsKey(start)){
            roots.put(start, start);
            ratios.put(start, 1.0);
        }
        
        if(!roots.containsKey(end)){
            roots.put(end, end);
            ratios.put(end, 1.0);
        }
        
        String rootStart = find(roots, ratios, start);
        String rootEnd = find(roots, ratios, end);
        roots.put(rootStart, rootEnd);
        ratios.put(rootStart, val * ratios.get(end) / ratios.get(start));
    }
    
    private String find(Map<String, String> roots, Map<String, Double> ratios, String start){
        if(start.equals(roots.get(start))) return start;
        
        String father = roots.get(start);
        String grandpa = find(roots, ratios, father);
        roots.put(start, grandpa);  // path compression
        ratios.put(start, ratios.get(start) * ratios.get(father));
        return grandpa;
    }
}