/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *  W, maximum width
 * 
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.idiotleon.leetcode.lvl2.lc0226;

import java.util.LinkedList;
import java.util.Queue;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null){
                queue.offer(node.left);
            }
            
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        
        return root;
    }
}