/**
 * https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * 
 * 
 * Time Complexities:
 *  O(N * lg(N))
 *  `getKthAncestor()`, O(lg(N))
 * 
 * Space Complexity:    O()
 * 
 * implemented in the way of DFS with memoization
 * 
 * References:
 *  https://leetcode.com/problems/kth-ancestor-of-a-tree-node/discuss/686591/Java-Clean-(Binary-Lifting)
 */
package com.idiotleon.leetcode.lvl5.lc1483;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0BinaryLifting1 {
    private Map<Integer, List<Integer>> children;
    private Integer[][] memo;

    public SolutionApproach0BinaryLifting1(int n, int[] parent) {
        this.children = new HashMap<Integer, List<Integer>>();
        this.memo = new Integer[n][30];
        for(int i = 0; i < n; i++){
            int curNode = i;
            int parentNode = parent[i];
            children.putIfAbsent(parentNode, new ArrayList<Integer>());
            children.get(parentNode).add(curNode);
            if(i > 0) memo[curNode][0] = parent[i];
        }
        
        dfs(0);
    }
    
    private void dfs(int cur){
        for(int i = 1; memo[cur][i - 1] != null; i++){
            int jumpToNextNode = memo[cur][i - 1];
            memo[cur][i] = memo[jumpToNextNode][i - 1];
        }
        
        for(int child : children.getOrDefault(cur, new ArrayList<Integer>()))
            dfs(child);
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i = 0; k > 0; i++){
            if(k % 2 == 1){
                if(memo[node][i] == null) return -1;
                node = memo[node][i];
            }
            
            k /= 2;
        }
        
        return node;
    }
}