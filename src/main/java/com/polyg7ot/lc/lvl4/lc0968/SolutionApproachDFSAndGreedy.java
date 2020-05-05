/**
 * https://leetcode.com/problems/binary-tree-cameras/
 * 
 * https://leetcode.com/problems/binary-tree-cameras/discuss/211966/Super-Clean-Java-solution-beat-100-DFS-O(n)-time-complexity
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(lgN)
 */
package com.polyg7ot.lc.lvl4.lc0968;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSAndGreedy {
    private int NOT_MONITORED = 0;
    private int MONITORED_NOCAM = 1;
    private int MONITORED_WITHCAM = 2;
    
    private int cameras = 0;
    
    public int minCameraCover(TreeNode root) {
        if(root == null) return cameras;
        
        int top = dfs(root);
        return cameras + (top == NOT_MONITORED ? 1 : 0);
    }
    
    private int dfs(TreeNode node){
        if(node == null) return MONITORED_NOCAM;
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if(left == MONITORED_NOCAM && right == MONITORED_NOCAM){
            return NOT_MONITORED;
        }else if(left == NOT_MONITORED || right == NOT_MONITORED){
            cameras++;
            return MONITORED_WITHCAM;
        }else{
            return MONITORED_NOCAM;
        }
    }
}