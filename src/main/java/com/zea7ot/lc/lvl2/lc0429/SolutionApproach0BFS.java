package com.zea7ot.lc.lvl2.lc0429;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * 
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(W) + O(N)
 *  W, the maximum width of the N-ary Tree
 *  O(N), consumed by the answer array
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.zea7ot.utils.data_structure.tree.NaryTreeNode;

public class SolutionApproach0BFS {
    public List<List<Integer>> levelOrder(NaryTreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        Queue<NaryTreeNode> queue = new LinkedList<NaryTreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; i++){
                NaryTreeNode cur = queue.poll();
                list.add(cur.val);
                queue.addAll(cur.children);
            }
            
            ans.add(list);
        }
        
        return ans;
    }
}