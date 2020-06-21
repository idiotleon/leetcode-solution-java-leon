/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Follow up:
 *  What if the BST is modified (insert/delete operations) often 
 *  and you need to find the kth smallest frequently? 
 *  How would you optimize the kthSmallest routine
 */
package com.zea7ot.lc.lvl4.lc0230.follow_up;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class Solution {
    private TreeNode root;
    private int leftSubtreeCount;

    public Solution(TreeNode root){
        this.root = root;

        // to get the total counts of nodes in the left subtree,
        // with root node excluded
        inorderCount(root.left);
    }

    public int kthSmallest(int k){
        if(k > leftSubtreeCount + 1){
            return inorderSearch(root.right, new int[]{k - leftSubtreeCount - 1});
        }else if(k < leftSubtreeCount + 1){
            return inorderSearch(root.left, new int[]{leftSubtreeCount + 1 - k});
        }else return root.val;
    }

    public void insert(int newNodeVal){
        if(newNodeVal < root.val) leftSubtreeCount++;

        insert(this.root, newNodeVal);
    }

    public void insert(TreeNode newNode){
        if(newNode.val < root.val) leftSubtreeCount++;

        // to insert the node into the tree
        insert(this.root, newNode);
    }

    public void delete(TreeNode node){
        if(node.val < root.val) leftSubtreeCount--;

        // to delete the node from the tree
        delete(this.root, node);
    }

    private int inorderSearch(TreeNode node, int[] steps){
        if(node == null) return 0;

        inorderSearch(node.left, steps);
        --steps[0];
        if(steps[0] == 0) return node.val;
        inorderSearch(node.right, steps);

        return -1;
    }

    /**
     * Time Complexity: O(H) in general, O(N) in the worst case
     */
    private TreeNode delete(TreeNode root, int key){
        if(root == null) return root;

        if(key < root.val){
            root.left = delete(root.left, key);
        }else if(key > root.val){
            root.right = delete(root.right, key);
        }else{
            // situations where node has only one (right) child
            if(root.left == null) return root.right;
            // situations where node has only one (left) child
            else if(root.right == null) return root.left;

            // situations where node has two children
            // to get the inorder successor
            root.val = minValue(root.right);
            // to delete the inorder successor
            root.right = delete(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root){
        int min = root.val;
        while(root.left != null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    private TreeNode delete(TreeNode root, TreeNode node){
        return delete(root, node.val);
    }

    /**
     * Time Complexity: O(H) in general, O(N) in the worst case
     */
    private TreeNode insert(TreeNode root, int newNodeVal){
        if(root == null){
            root = new TreeNode(newNodeVal);
            return root;
        }

        if(newNodeVal < root.val){
            root.left = insert(root.left, newNodeVal);
        }else if(newNodeVal > root.val){
            root.right = insert(root.right, newNodeVal);
        }

        return root;
    }

    private TreeNode insert(TreeNode root, TreeNode newNode){
        return insert(root, newNode.val);
    }

    private void inorderCount(TreeNode node){
        if(node == null) return;

        inorderCount(node.left);
        ++leftSubtreeCount;
        inorderCount(node.right);
    }
}