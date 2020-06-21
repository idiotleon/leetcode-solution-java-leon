/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
package com.zea7ot.lc.lvl3.lc0156;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachIteration {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root, next = null, temp = null, prev = null;
        
        while(cur != null){
            next = cur.left;
            
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;
            
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}