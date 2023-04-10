/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  
 */
package com.idiotleon.leetcode.lvl2.lc0971;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> path = new ArrayList<Integer>();
        if(dfs(root, voyage, 0, path) == -1) return Arrays.asList(-1);
        
        return path;
    }
    
    private int dfs(TreeNode node, int[] voyage, int idx, List<Integer> path){
        if(node == null) return idx;
        if(node.val != voyage[idx]) return -1;
        
        int left = dfs(node.left, voyage, idx + 1, path);
        if(left != -1) 
            return dfs(node.right, voyage, left, path);
        
        // need a flip
        path.add(node.val);
        int right = dfs(node.right, voyage, idx + 1, path);
        if(right != -1) 
            return dfs(node.left, voyage, right, path);
        
        return -1;
    }
}