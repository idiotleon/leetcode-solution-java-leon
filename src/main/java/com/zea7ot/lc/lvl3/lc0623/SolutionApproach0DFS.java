/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/add-one-row-to-tree/discuss/104547/Java-three-methods-one-BFS-and-two-DFS
 */
package com.zea7ot.lc.lvl3.lc0623;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        dfs(root, 1, v, d);
        return root;
    }
    
    private void dfs(TreeNode node, int depth, int v, int d){
        if(node == null) return;
        if(depth < d - 1){
            dfs(node.left, depth + 1, v, d);
            dfs(node.right, depth + 1, v, d);
        }else{
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }
    }
}