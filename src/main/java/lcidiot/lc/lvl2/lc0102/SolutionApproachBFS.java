/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
package main.java.lcidiot.lc.lvl2.lc0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> intermediate = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            intermediate.clear();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                intermediate.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            
            ans.add(new ArrayList<Integer>(intermediate));
        }
        
        return ans;
    }
}