/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/discuss/334577/JavaC%2B%2BPython-Two-Recursive-Solution
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 */
package com.polyg7ot.lc.lvl3.lc1123;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFSBottomUp1 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNodeWithDepth node = getLCA(root, 0);
        return node.node;
    }
    
    private TreeNodeWithDepth getLCA(TreeNode node, int depth){
        if(node == null) return new TreeNodeWithDepth(node, depth);
        
        TreeNodeWithDepth left = getLCA(node.left, depth + 1);
        TreeNodeWithDepth right = getLCA(node.right, depth + 1);
        
        if(left.depth == right.depth){
            return new TreeNodeWithDepth(node, left.depth);
        }else{
            return left.depth > right.depth ? left : right;
        }
    }
    
    private class TreeNodeWithDepth{
        TreeNode node;
        int depth;
        TreeNodeWithDepth(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}