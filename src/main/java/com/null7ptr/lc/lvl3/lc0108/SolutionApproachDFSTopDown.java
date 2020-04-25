/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
package com.null7ptr.lc.lvl3.lc0108;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    private TreeNode dfs(int[] nums, int left, int right){
        if(left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}