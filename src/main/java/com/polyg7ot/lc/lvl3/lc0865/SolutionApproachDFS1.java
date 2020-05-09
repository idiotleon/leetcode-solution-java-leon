/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
package com.polyg7ot.lc.lvl3.lc0865;

import javafx.util.Pair;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachDFS1 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }
    
    private Pair<Integer, TreeNode> deep(TreeNode node){
        if(node == null) return new Pair(0, null);
        
        Pair<Integer, TreeNode> left = deep(node.left);
        Pair<Integer, TreeNode> right = deep(node.right);
        
        int leftVal = left.getKey();
        int rightVal = right.getKey();
        
        if(leftVal == rightVal) {
            return new Pair(leftVal + 1, node);
        }else if(leftVal > rightVal){
            return new Pair(leftVal + 1, left.getValue());
        }else{
            return new Pair(rightVal + 1, right.getValue());
        }
    }
}