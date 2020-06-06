/**
 * https://leetcode.com/problems/binary-tree-cameras/
 * 
 * https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
 * 
 * Here is our greedy solution:
 *  Set cameras on all leaves' parents, thenremove all covered nodes.
 *  Repeat step 1 until all nodes are covered.
 */
package com.zea7ot.lc.lvl4.lc0968;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSAndGreedy1 {
    private int result = 0;
    
    public int minCameraCover(TreeNode root) {
        return (dfs(root) == 0 ? 1 : 0) + result;
    }
    
    private int dfs(TreeNode node){
        if(node == null) return 2;
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if(left == 0 || right == 0){
            this.result++;
            return 1;
        }
        
        if(left == 1 || right == 1){
            return 2;
        }
        
        return 0;
    }
}