/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0270;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BinarySearch1 {
    public int closestValue(TreeNode root, double target) {
        double closest = Double.MAX_VALUE;
        int ans = root.val;
        TreeNode cur = root;

        while (cur != null) {
            if (Math.abs(cur.val - target) < closest) {
                ans = cur.val;
                closest = Math.abs(cur.val - target);
            }

            if (cur.val > target)
                cur = cur.left;
            else
                cur = cur.right;
        }

        return ans;
    }
}