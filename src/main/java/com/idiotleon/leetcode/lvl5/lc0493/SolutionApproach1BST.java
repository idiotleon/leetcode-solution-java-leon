/**
 * https://leetcode.com/problems/reverse-pairs/
 * 
 * TLEed
 * Time Complexity: O(N ^ 2) in the worst case
 *  O(N * lg(N)) if the tree is balanced
 * Space Complexity:
 * 
 * 
 * References:
 *  https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
 */
package com.idiotleon.leetcode.lvl5.lc0493;

public class SolutionApproach1BST {
    public int reversePairs(int[] nums) {
        int ans = 0;
        TreeNode root = null;
        
        for(int num : nums){
            ans += search(root, 2L * num + 1);
            root = insert(root, num);
        }
        
        return ans;
    }
    
    private int search(TreeNode node, long val){
        if(node == null) return 0;
        else if(val == node.val) return node.count;
        else if(val < node.val) return node.count + search(node.left, val);
        else return search(node.right, val);
    }
    
    private TreeNode insert(TreeNode node, int val){
        if(node == null) node = new TreeNode(val);
        else if(val == node.val) node.count++;
        else if(val < node.val) node.left = insert(node.left, val);
        else{
            node.count++;
            node.right = insert(node.right, val);
        }
        
        return node;
    }
    
    private class TreeNode{
        protected int val, count;
        protected TreeNode left, right;
        
        public TreeNode(int val){
            this.val = val;
            this.count = 1;
        }
    } 
}