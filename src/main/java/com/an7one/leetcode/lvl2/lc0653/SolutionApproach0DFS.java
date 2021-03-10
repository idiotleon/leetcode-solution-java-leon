/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC%2B%2B-Three-simple-methods-choose-one-you-like
 */
package com.an7one.leetcode.lvl2.lc0653;

import java.util.HashSet;
import java.util.Set;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        return dfs(root, set, k);
    }
    
    private boolean dfs(TreeNode node, Set<Integer> set, int k){
        if(node == null) return false;
        if(set.contains(k - node.val)) return true;
        set.add(node.val);
        return dfs(node.left, set, k) || dfs(node.right, set, k);
    }
}