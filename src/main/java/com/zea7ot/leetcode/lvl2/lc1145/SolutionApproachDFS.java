/**
 * https://leetcode.com/problems/binary-tree-coloring-game/
 */
package com.zea7ot.leetcode.lvl2.lc1145;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    private int left, right;
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // sanity check
        if(root == null) return false;

        // initialization
        this.left = 0;
        this.right = 0;

        // dfs
        dfs(root, x);
        int parent = n - (1 + this.left + this.right);
        return Math.max(parent, Math.max(this.left, this.right)) > n / 2;
    }
    
    private int dfs(TreeNode node, int x){
        if(node == null) return 0;
        
        int left = dfs(node.left, x);
        int right = dfs(node.right, x);
        if(node.val == x){
            this.left = left;
            this.right = right;
        }
        
        return 1 + left + right;
    }
}