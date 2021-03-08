/**
 * https://leetcode.com/problems/correct-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/correct-a-binary-tree/discuss/940769/Java-HashSet.-One-Pass.-Short.
 */
package com.zea7ot.leetcode.lvl3.lc1660;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive {
    public TreeNode correctBinaryTree(TreeNode root) {
        Set<Integer> seen = new HashSet<>();
        
        return dfs(root, seen);
    }
    
    private TreeNode dfs(TreeNode node, Set<Integer> seen){
        if(node == null) return null;
        if(node.right != null && seen.contains(node.right.val)) return null;
        seen.add(node.val);
        node.right = dfs(node.right, seen);
        node.left = dfs(node.left, seen);
        return node;
    }
}
