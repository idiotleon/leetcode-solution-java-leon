/**
 * @author: Leon
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(W)
 *  W, the maximum width of the tree
 */
package com.zea7ot.leetcode.lvl3.lc1448;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach1BFS {
    public int goodNodes(TreeNode root) {
        // sanity check
        if (root == null) return 0;

        Queue<Wrapper> queue = new LinkedList<Wrapper>();
        queue.add(new Wrapper(root, root.val));
        int count = 1;

        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                Wrapper cur = queue.poll();
                int maxValue = cur.maxValue;
                
                if(cur.node.left != null){
                    int val = cur.node.left.val;
                    if(val >= maxValue) count++;
                    queue.add(new Wrapper(cur.node.left, Math.max(maxValue, val)));
                }
                
                if(cur.node.right != null){
                    int val = cur.node.right.val;
                    if(val >= maxValue) count++;
                    queue.add(new Wrapper(cur.node.right, Math.max(maxValue, val)));
                }
            }
        }
        
        return count;
    }
    
    private class Wrapper{
        protected TreeNode node;
        protected int maxValue;
        
        protected Wrapper(TreeNode node, int maxValue){
            this.node = node;
            this.maxValue = maxValue;
        }
    }
}