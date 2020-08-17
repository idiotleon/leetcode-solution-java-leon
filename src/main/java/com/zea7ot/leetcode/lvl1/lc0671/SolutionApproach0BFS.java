/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/discuss/430909/JAVA-BFS-Solution
 */
package com.zea7ot.leetcode.lvl1.lc0671;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int findSecondMinimumValue(TreeNode root) {
        // sanity check
        if(root == null || root.left == null || root.right == null) return -1;
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int secondMin = -1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
            if(cur.val == root.val) continue;
            if(secondMin == -1) secondMin = cur.val;
            else secondMin = Math.min(secondMin, cur.val);
        }
        
        return secondMin;
    }
}