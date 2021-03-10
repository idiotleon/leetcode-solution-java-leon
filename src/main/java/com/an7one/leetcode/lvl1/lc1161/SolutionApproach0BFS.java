/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl1.lc1161;

import java.util.LinkedList;
import java.util.Queue;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int maxLevelSum(TreeNode root) {
        // sanity check
        if(root == null) return 0;

        int maxSum = Integer.MIN_VALUE, maxLevel = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int level = 0;
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            int sum = 0;
            ++level;
            for(int i = 0; i < SIZE; i++){
                TreeNode top = queue.poll();
                sum += top.val;
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            
            if(maxSum < sum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        
        return maxLevel;
    }
}