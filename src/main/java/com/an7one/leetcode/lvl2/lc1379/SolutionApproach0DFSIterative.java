/**
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * 
 * Time Complexity:     O(2 * N) ~ O(N)
 * Space Complexity:    O(2 * H) ~ O(H)
 */
package com.an7one.leetcode.lvl2.lc1379;

import java.util.ArrayDeque;
import java.util.Deque;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSIterative {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> originalStack = new ArrayDeque<TreeNode>();
        pushLeft(original, originalStack);
        Deque<TreeNode> clonedStack = new ArrayDeque<TreeNode>();
        pushLeft(cloned, clonedStack);
        
        while(!originalStack.isEmpty()){
            TreeNode originalTop = originalStack.pop();
            TreeNode clonedTop = clonedStack.pop();
            if(originalTop == target)
                return clonedTop;
            
            if(originalTop.right == null) continue;
            pushLeft(originalTop.right, originalStack);
            pushLeft(clonedTop.right, clonedStack);
        }
        
        return null;
    }
    
    private void pushLeft(TreeNode node, Deque<TreeNode> stack){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}