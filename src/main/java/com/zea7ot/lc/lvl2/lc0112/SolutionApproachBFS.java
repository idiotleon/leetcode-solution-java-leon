/**
 * https://leetcode.com/problems/path-sum/
 */
package com.zea7ot.lc.lvl2.lc0112;

import java.util.LinkedList;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachBFS {
    public boolean hasPathSumIteration(TreeNode root, int sum) {
        if(root == null) return false;
        
        LinkedList<TreeNode> nodeStack = new LinkedList<TreeNode>();
        LinkedList<Integer> sumStack = new LinkedList<Integer>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        
        TreeNode node;
        int curSum;
        while(!nodeStack.isEmpty()){
            node = nodeStack.pollLast();
            curSum = sumStack.pollLast();
            
            if(node.left == null && node.right == null && curSum == 0) return true;
            
            if(node.right != null){
                nodeStack.add(node.right);
                sumStack.add(curSum - node.right.val);
            }
            
            if(node.left != null){
                nodeStack.add(node.left);
                sumStack.add(curSum - node.left.val);
            }
        }
        
        return false;
    } 
}