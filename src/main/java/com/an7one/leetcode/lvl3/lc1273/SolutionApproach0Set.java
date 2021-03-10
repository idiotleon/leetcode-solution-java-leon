/**
 * https://leetcode.com/problems/delete-tree-nodes/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/delete-tree-nodes/discuss/440792/JavaO(n)/397608
 *  https://leetcode.com/problems/delete-tree-nodes/discuss/440792/JavaO(n)
 */
package com.an7one.leetcode.lvl3.lc1273;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        final int N = parent.length;
        for(int i = N - 1; i > 0; i--){
            value[parent[i]] += value[i];
        }
        
        Set<Integer> deleted = new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            if(value[i] == 0 || deleted.contains(parent[i])){
                deleted.add(i);
            }
        }
        
        return nodes - deleted.size();
    }
}