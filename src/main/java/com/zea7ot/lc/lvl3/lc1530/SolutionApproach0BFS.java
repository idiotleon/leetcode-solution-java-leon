/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 * 
 * Time Complexity:     O(N) + O(distance)
 * Space Complexity:    O(N) + O(H)
 */
package com.zea7ot.lc.lvl3.lc1530;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    private int count;
    
    public int countPairs(TreeNode root, int distance) {
        // sanity check
        if(root == null || (root.left == null && root.right == null)) return 0;
        
        // step 1:
		//  1. to find all leaves
		//  2. to build up the map `toParent`, kind of turning a tree into an undirected graph.
		//  To turn a tree into a real undirected is technically feasible but not recommended or necessary because of the extra efforts and code
        Map<TreeNode, TreeNode> toParent = new HashMap<TreeNode, TreeNode>();
        Set<TreeNode> leaves = new HashSet<TreeNode>();
        dfs(root, toParent, leaves);
        
        this.count = 0;
        
        // step 2:
        // to BFS with each `leaf` to find all eligible/good nodes
        // this remains to be optimized because of doubled/overlapped costs between each node in one pair
        for(TreeNode leaf : leaves)
            bfs(leaf, toParent, leaves, distance);
        
        return count / 2;
    }
    
    private void bfs(TreeNode node, Map<TreeNode, TreeNode> toParent, Set<TreeNode> leaves, int distance){
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(node);
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; ++i){
                TreeNode top = queue.poll();
                if(!visited.add(top)) continue;
                if(leaves.contains(top) && top != node) ++count;
                
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
                if(toParent.containsKey(top)) queue.offer(toParent.get(top));
            }
            
            if(--distance == -1) break;
        }
    }
    
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> toParent, Set<TreeNode> leaves){
        if(isLeaf(node)) leaves.add(node);
        
        if(node.left != null){
            toParent.put(node.left, node);
            dfs(node.left, toParent, leaves);
        }
        
        if(node.right != null){
            toParent.put(node.right, node);
            dfs(node.right, toParent, leaves);
        }
    }
    
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}