/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 */
package main.java.lcidiot.lc0156;

import main.java.lcidiot.utils.TreeNode;

class SolutionApproachIteration {
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