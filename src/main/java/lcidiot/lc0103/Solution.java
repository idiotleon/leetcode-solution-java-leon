/**
 * 
 */
package main.java.lcidiot.lc0103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        List<Integer> intermediate = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            intermediate.clear();
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(level % 2 == 0) intermediate.add(cur.val);
                else intermediate.add(0, cur.val);

                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            
            ++level;
            ans.add(new ArrayList<Integer>(intermediate));
        }
        
        return ans;
    }
}