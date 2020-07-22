/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.lc.lvl3.lc0103;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(root == null) return ans;
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            LinkedList<Integer> intermediate = new LinkedList<Integer>();
            
            for(int i = 0; i < SIZE; i++){
                TreeNode cur = queue.poll();
                if(level % 2 == 0) intermediate.addLast(cur.val);
                else intermediate.addFirst(cur.val);

                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            
            ++level;
            ans.add(intermediate);
        }
        
        return ans;
    }
}