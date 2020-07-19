/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O()
 */
package com.zea7ot.lc.lvl3.lc0623;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        for(int level = 0; level < d - 2; ++level){
            final int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                TreeNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
        }
        
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            TreeNode temp = top.left;
            top.left = new TreeNode(v);
            top.left.left = temp;
            
            temp = top.right;
            top.right = new TreeNode(v);
            top.right.right = temp;
        }
        
        return root;
    }
}