/**
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.lc.lvl4.lc1028;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Stack {
    public TreeNode recoverFromPreorder(String S) {
        // sanity check
        if(S == null || S.isEmpty()) return null;

        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        final char[] CHS = S.toCharArray();
        final int L = S.length();
        int idx = 0;
        
        while(idx < L){
            // to locate the level
            int depth = 0;
            while(idx < L && CHS[idx] == '-'){
                depth++;
                idx++;
            }
            
            // to construct the node value
            int val = 0;
            while(idx < L && CHS[idx] != '-'){
                val = val * 10 + (CHS[idx] - '0');
                idx++;
            }
            
            // if the size of the stack is larger than the level of the node,
            // to find the correct parent for the current level
            while(deque.size() > depth) deque.pollLast();
            
            TreeNode node = new TreeNode(val);
            if(!deque.isEmpty()){
                TreeNode parent = deque.peekLast();
                if(parent.left == null) parent.left = node;
                else parent.right = node;
            }
            deque.addLast(node);
        }
        return deque.peekFirst();
    }
}