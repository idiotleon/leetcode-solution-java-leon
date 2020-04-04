/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
package main.java.lcidiot.lc0111;

import main.java.lcidiot.utils.TreeNode;

public class SolutionApproachDFSTopDown {
    private int min;
    
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        min = Integer.MAX_VALUE;
        dfs(root, 1);
        return min;
    }
    
    private void dfs(TreeNode node, int curHeight){
        if(node == null) return;
        
        if(node.left == null && node.right == null){
            min = Math.min(min, curHeight);
        }
        
        if(node.left != null){
            curHeight++;
            dfs(node.left, curHeight);
            curHeight--;
        }
        
        if(node.right != null){
            curHeight++;
            dfs(node.right, curHeight);
            curHeight--;
        }
    }  
}