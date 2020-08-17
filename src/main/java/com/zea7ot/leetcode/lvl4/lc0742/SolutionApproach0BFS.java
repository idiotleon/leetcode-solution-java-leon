/**
 * https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/closest-leaf-in-a-binary-tree/discuss/109960/Java-DFS-%2B-BFS-27ms
 */
package com.zea7ot.leetcode.lvl4.lc0742;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        Set<TreeNode> seen = new HashSet<TreeNode>();
        
        TreeNode start = dfs(root, k, map);
        queue.add(start);
        seen.add(start);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null) return node.val;
            if(node.left != null && seen.add(node.left)) queue.add(node.left);
            if(node.right != null && seen.add(node.right)) queue.add(node.right);
            if(map.containsKey(node) && seen.add(map.get(node))) queue.add(map.get(node));
        }
        
        return -1;
    }
    
    private TreeNode dfs(TreeNode node, int k, Map<TreeNode, TreeNode> map){
        if(node.val == k) return node;
        
        if(node.left != null){
            map.put(node.left, node);
            TreeNode left = dfs(node.left, k, map);
            if(left != null) return left;
        }
        
        if(node.right != null){
            map.put(node.right, node);
            TreeNode right = dfs(node.right, k, map);
            if(right != null) return right;
        }
        
        return null;
    }
}