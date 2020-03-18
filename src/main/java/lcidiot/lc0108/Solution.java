/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
package main.java.lcidiot.lc0108;

import main.java.lcidiot.utils.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }
    
    private TreeNode helper(int left, int right, int[] nums){
        if(left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }
}