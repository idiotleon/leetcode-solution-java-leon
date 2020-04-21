/**
 * https://leetcode.com/problems/same-tree/
 */
package main.java.lcidiot.lc0100;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachBFS {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            
            if(first == null && second == null) continue;
            else if(first == null || second == null || first.val != second.val) return false;
            
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        
        return true;
    }
}