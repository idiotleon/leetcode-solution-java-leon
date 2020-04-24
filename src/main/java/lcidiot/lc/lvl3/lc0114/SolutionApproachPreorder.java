/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
package main.java.lcidiot.lc.lvl3.lc0114;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachPreorder {
    public void flatten(TreeNode root) {
        // sanity check
        if(root == null) return;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
            
        preorder(root, queue);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            cur.left = null;
            cur.right = queue.peek();
        }
    }
        
    private void preorder(TreeNode root, Queue<TreeNode> queue){
        if(root == null) return;
            
        queue.add(root);
        preorder(root.left, queue);
        preorder(root.right, queue);
    }
}