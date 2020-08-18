/**
 * https://leetcode.com/problems/evaluate-division/
 * 
 * Time Complexity: O(equations.size() + queries.size())
 * Space Complexity: O(equations.size())
 * 
 * References:
 *  https://leetcode.com/problems/evaluate-division/discuss/278276/Java-Union-find-and-DFS
 */
package com.zea7ot.leetcode.lvl4.lc0399;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0UnionFind {
    private Map<String, String> roots = new HashMap<String, String>();
    private Map<String, Double> vals = new HashMap<String, Double>();
    
    public double[] calcEquation(List<List<String>> equations, 
                                 double[] values, 
                                 List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < values.length; ++i){
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        for(int i = 0; i < queries.size(); i++){
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            ans[i] = (roots.containsKey(x) && roots.containsKey(y) && find(x) == find(y)) ? vals.get(x) / vals.get(y) : -1.0;
        }
        
        return ans;
    }
    
    private void add(String x){
        if(roots.containsKey(x)) return;
        roots.put(x, x);
        vals.put(x, 1.0);
    }
    
    private String find(String x){
        String root = roots.getOrDefault(x, x);
        if(x != root){
            String grandRoot = find(root);
            vals.put(x, vals.get(x) * vals.get(root));
            roots.put(x, grandRoot);
        }
        return roots.getOrDefault(x, x);
    }
    
    private void union(String x, String y, double v){
        add(x);
        add(y);
        String rootX = find(x), rootY = find(y);
        roots.put(rootX, rootY);
        vals.put(rootX, v * vals.get(y) / vals.get(x));
    }
}