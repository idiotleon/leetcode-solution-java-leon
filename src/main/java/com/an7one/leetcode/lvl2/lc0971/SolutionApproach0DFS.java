/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/discuss/214216/JavaC%2B%2BPython-DFS-Solution
 */
package com.an7one.leetcode.lvl2.lc0971;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> path = new ArrayList<Integer>();
        int[] idx = {0};
        return dfs(root, voyage, idx, path) ? path : Arrays.asList(-1);
    }
    
    private boolean dfs(TreeNode node, int[] voyage, int[] idx, List<Integer> path){
        if(node == null) return true;
        if(node.val != voyage[idx[0]++]) return false;
        if(node.left != null && node.left.val != voyage[idx[0]]){
            path.add(node.val);
            return dfs(node.right, voyage, idx, path) && dfs(node.left, voyage, idx, path);
        }
        
        return dfs(node.left, voyage, idx, path) && dfs(node.right, voyage, idx, path);
    }
}