/**
 * https://leetcode.com/problems/evaluate-division/
 * 
 * Time Complexity: 
 *  O(queries.size() * (equations.size() + 2 * values.length)) + O(equations.size()) ~ O(queries.size() * (equations.size() + 2 * values.length))
 *      O(equations.size()), to build up the graph
 *      O(queries.size() * (equations.size() + 2 * values.length)), to DFS the graph
 * 
 * Space Complexity: 
 *  O(2 * (equations.size() + values.length)) + O(values.length) ~ O(2 * (equations.size() + values.length))
 *      O(2 * (equations.size() + values.length)), to build up the graph
 *      O(values.length), for the visited set
 * 
 * References:
 *  https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
 */
package com.zea7ot.leetcode.lvl4.lc0399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0DFS {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++){
            ans[i] = getPathWeight(graph, 
                                   new HashSet<String>(), 
                                   queries.get(i).get(0), 
                                   queries.get(i).get(1));
        }
        
        return ans;
    }
    
    private double getPathWeight(Map<String, Map<String, Double>> graph, 
                                 Set<String> visited, 
                                 String start, 
                                 String end){
        
        if(!graph.containsKey(start)) return -1.0;
        
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        
        visited.add(start);
        for(Map.Entry<String, Double> neighbor : graph.get(start).entrySet()){
            if(!visited.contains(neighbor.getKey())){
                double productWeight = getPathWeight(graph, visited,neighbor.getKey(), end);
                if(productWeight != -1.0){
                    return neighbor.getValue() * productWeight;
                }
            }
        }
        
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, 
                                                        double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<String, Map<String, Double>>();
        
        for(int i = 0; i < equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<String, Double>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<String, Double>());
            graph.get(v).put(u, 1 / values[i]);
        }
        
        return graph;
    }
}