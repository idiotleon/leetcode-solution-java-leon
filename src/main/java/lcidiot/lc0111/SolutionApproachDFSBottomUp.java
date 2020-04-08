/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
package main.java.lcidiot.lc0111;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachDFSBottomUp1 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0 || right == 0){ 
            // to make sure that the height of leaf nodes is taken
            return Math.max(left, right) + 1;
        }else{
            return Math.min(left, right) + 1;
        }
    }
}

class SolutionApproachDFSBottomUp2 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36188/Very-easy-with-recursion-1ms-Java-solution/34395
 * 
 * If a node has both left and right child, 
 * it means that the node has both left child tree and right child tree, 
 * so we just recursively find the min height of subtree. 
 * 
 * However, if a node has only one whichever subtree, let's say left subtree, what we should do? 
 * Can we still find the min between the left subtree and a null? 
 * Of course not, so we should find the height of the left subtree itself, 
 * so we use max in this condition.
 */
class SolutionApproachDFSBottomUp3{
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left != null && root.right != null){
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }else{
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}

class SolutionApproachDFSBottomUp4 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        
        int minDepth = Integer.MAX_VALUE;
        
        if(root.left != null){
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        
        if(root.right != null){
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        
        return minDepth + 1;
    }
}