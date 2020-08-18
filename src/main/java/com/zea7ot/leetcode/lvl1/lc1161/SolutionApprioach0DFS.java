/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/discuss/360968/JavaPython-3-Two-codes-language%3A-BFS-level-traversal-and-DFS-level-sum.
 */
package com.zea7ot.leetcode.lvl1.lc1161;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApprioach0DFS {
    public int maxLevelSum(TreeNode root) {
        // sanity check
        if(root == null) return 0;

        List<Integer> map = new ArrayList<Integer>();
        dfs(root, map, 0);
        
        final int N = map.size();
        int maxLevel = 0;
        for(int i = 0; i < N; i++){
            if(map.get(maxLevel) < map.get(i)){
                maxLevel = i;
            }
        }
        
        return maxLevel + 1;
    }
    
    private void dfs(TreeNode node, List<Integer> map, int level){
        if(node == null) return;
        if(map.size() == level) map.add(node.val);
        else map.set(level, map.get(level) + node.val);
        dfs(node.left, map, level + 1);
        dfs(node.right, map, level + 1);
    }
}