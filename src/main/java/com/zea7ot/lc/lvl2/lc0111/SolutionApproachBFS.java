/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
package com.zea7ot.lc.lvl2.lc0111;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachBFS {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int height = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            height++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null)
                    return height;
                
                if(cur.left != null) 
                    queue.offer(cur.left);
                
                if(cur.right != null) 
                    queue.offer(cur.right);
            }
        }
        
        return height;
    }
}