/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/106653/Java-One-Queue-Solution-with-HashMap/492554
 */
package com.zea7ot.lc.lvl3.lc0662;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int widthOfBinaryTree(TreeNode root) {
        // sanity check
        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(root, 0));
        int max = 0;
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            int start = 0, end = 0;
            for(int i = 0; i < SIZE; i++){
                Node top = queue.poll();
                int idx = top.idx;
                if(i == 0) start = idx;
                if(i == SIZE - 1) end = idx;
                if(top.node.left != null)
                    queue.offer(new Node(top.node.left, 2 * idx + 1));
                
                if(top.node.right != null)
                    queue.offer(new Node(top.node.right, 2 * idx + 2));
            }
            
            max = Math.max(max, end - start + 1);
        }
        
        return max;
    }
    
    private class Node{
        protected TreeNode node;
        protected int idx;
        
        protected Node(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
}