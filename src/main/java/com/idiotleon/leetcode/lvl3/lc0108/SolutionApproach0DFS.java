/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(lg(N))
 * 
 * a top-down approach
 */
package com.idiotleon.leetcode.lvl3.lc0108;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public TreeNode sortedArrayToBST(int[] nums) {
        final int N = nums.length;
        return dfs(0, N - 1, nums);
    }

    private TreeNode dfs(int lo, int hi, int[] nums) {
        if (lo > hi)
            return null;

        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(lo, mid - 1, nums);
        root.right = dfs(mid + 1, hi, nums);
        return root;
    }
}