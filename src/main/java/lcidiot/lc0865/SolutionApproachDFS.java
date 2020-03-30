/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
package main.java.lcidiot.lc0865;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachDFS {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == right) return root;
        if(left > right) return subtreeWithAllDeepest(root.left);
        return subtreeWithAllDeepest(root.right);
    }
    
    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}