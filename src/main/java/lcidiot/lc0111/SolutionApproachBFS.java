package main.java.lcidiot.lc0111;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

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