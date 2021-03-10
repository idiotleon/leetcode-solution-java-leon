/**
 * https://leetcode.com/problems/print-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H ^ 2) + O(2 * W)
 * 
 * References:
 *  https://leetcode.com/problems/print-binary-tree/discuss/106269/Java-Iterative-Level-Order-Traversal-with-Queue
 */
package com.an7one.leetcode.lvl2.lc0655;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(root == null) return ans;
        
        final int NR = getHeight(root), NC = (int)Math.pow(2, NR) - 1;
        for(int row = 0; row < NR; row++){
            List<String> placeholder = new ArrayList<String>();
            for(int col = 0; col < NC; col++) placeholder.add("");
            ans.add(placeholder);
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        Deque<int[]> idxQueue = new ArrayDeque<int[]>();
        idxQueue.offer(new int[]{0, NC - 1});
        
        int level = 0;
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                TreeNode cur = queue.poll();
                int[] indices = idxQueue.poll();
                
                int lo = indices[0], hi = indices[1];
                int mid = lo + (hi - lo) / 2;
                ans.get(level).set(mid, String.valueOf(cur.val));
                
                if(cur.left != null){
                    queue.offer(cur.left);
                    idxQueue.offer(new int[]{lo, mid - 1});
                }
                
                if(cur.right != null){
                    queue.offer(cur.right);
                    idxQueue.offer(new int[]{mid + 1, hi});
                }
            }
            
            level++;
        }
        
        return ans;
    }
    
    private int getHeight(TreeNode node){
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}