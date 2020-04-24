/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
package main.java.lcidiot.lc.lvl2.lc0104;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachBFS {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        // please be noted that height here should be initialized with 0, not 1
        // 1, or ++, should be performed when queue starts to poll
        int height = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            height++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                
                if(cur.left != null) 
                    queue.offer(cur.left);
                
                if(cur.right != null) 
                    queue.offer(cur.right);
            }
        }
        
        return height;
    }
}