/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
package main.java.lcidiot.lc0114;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFS1 {
    class SolutionApproachDFS2 {
        public void flatten2(TreeNode root) {
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
}