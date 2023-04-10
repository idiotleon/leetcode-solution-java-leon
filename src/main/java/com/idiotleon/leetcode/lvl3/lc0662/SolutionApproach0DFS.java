/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106654/JavaC++-Very-simple-dfs-solution/109026
 */
package com.idiotleon.leetcode.lvl3.lc0662;

import java.util.LinkedList;
import java.util.List;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    private int max;
    
    public int widthOfBinaryTree(TreeNode root) {
        this.max = 1;
        List<Integer> startIdxesOfLevel = new LinkedList<Integer>();
        dfs(root, 0, 1, startIdxesOfLevel);
        return max;
    }
    
    private void dfs(TreeNode node, 
                     int level, 
                     int idx, 
                     List<Integer> list){
        if(node == null) return;
        if(level == list.size()) list.add(idx);
        max = Math.max(max, idx + 1 - list.get(level));
        dfs(node.left, level + 1, idx * 2, list);
        dfs(node.right, level + 1, idx* 2 + 1, list);
    }
}