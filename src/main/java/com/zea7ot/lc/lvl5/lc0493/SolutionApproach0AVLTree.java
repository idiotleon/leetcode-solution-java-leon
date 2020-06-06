/**
 * https://leetcode.com/problems/reverse-pairs/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-"Reverse-Pairs"/101732
 *  https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
 */
package com.zea7ot.lc.lvl5.lc0493;

public class SolutionApproach0AVLTree {
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        
        TreeNode root = new TreeNode(nums[0]);
        int ans = 0;
        for(int i = 1; i < N; i++){
            ans += search(root, nums[i] * 2L);
            root = insert(root, (long)nums[i]);
        }
        
        return ans;
    }
    
    private int search(TreeNode node, long key){
        if(node == null) return 0;
        
        if(key < node.val) return node.rightCount + search(node.left, key);
        else return search(node.right, key);
    }
    
    private TreeNode insert(TreeNode node, long key){
        if(node == null) return new TreeNode(key);
        
        if(key < node.val){
            node.left = insert(node.left, key);
        }else if(key == node.val){
            node.rightCount++;
            return node;
        }else{
            node.rightCount++;
            node.right = insert(node.right, key);
        }
        
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        
        int balance = getBalance(node);
        
        if(balance > 1 && getHeight(node.left.left) > getHeight(node.left.right)){
            return rightRotate(node);
        }
        
        if(balance > 1 && getHeight(node.left.left) < getHeight(node.left.right)){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        if(balance < -1 && getHeight(node.right.left) < getHeight(node.right.right)){
            return leftRotate(node);
        }
        
        if(balance < -1 && getHeight(node.right.left) > getHeight(node.right.right)){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    private TreeNode leftRotate(TreeNode node){
        // to take care of nodes
        TreeNode newRoot = node.right;
        TreeNode b = newRoot.left;
        
        newRoot.left = node;
        node.right = b;
        
        // to take care of height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        
        // to take care of rightCount
        node.rightCount -= getRightCount(newRoot);
        
        return newRoot;
    }
    
    private TreeNode rightRotate(TreeNode node){
        // to take care of nodes
        TreeNode newRoot = node.left;
        TreeNode b = newRoot.right;
        
        newRoot.right = node;
        node.left = b;
        
        // to take care of height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        
        // to take care of rightCount
        newRoot.rightCount += getRightCount(node);
        
        return newRoot;
    }
    
    private int getBalance(TreeNode node){
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }
    
    private int getHeight(TreeNode node){
        return node == null ? 0 : node.height;
    }
    
    private int getRightCount(TreeNode node){
        return node == null ? 0 : node.rightCount;
    }
    
    private class TreeNode{
        protected long val;
        protected int rightCount;
        protected int height;
        
        protected TreeNode left;
        protected TreeNode right;
        
        public TreeNode(long val){
            this.val = val;
            height = 1;
            rightCount = 1;
        }
    }
}