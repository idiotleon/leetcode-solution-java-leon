/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 * 
 * References:
 *  https://leetcode.com/problems/average-of-levels-in-binary-tree/discuss/105107/Java-BFS-Solution
 */
package com.zea7ot.leetcode.lvl2.lc0637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        // sanity check
        if(root == null) return ans;
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            double sum = 0.0;
            for(int i = 0; i < SIZE; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            
            ans.add(sum / SIZE);
        }
        
        return ans;
    }
}