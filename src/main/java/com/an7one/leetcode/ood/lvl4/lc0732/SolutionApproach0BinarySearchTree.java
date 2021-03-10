/**
 * https://leetcode.com/problems/my-calendar-iii
 * 
 * Time Complexity:     O(N * lg(N))
 *  O(N ^ 2), if the binary search tree is skewed
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-iii/discuss/109575/Java-O(n)-BST-Method
 */
package com.an7one.leetcode.ood.lvl4.lc0732;

public class SolutionApproach0BinarySearchTree {
    private BSTNode root;
    private int cur, count;

    public SolutionApproach0BinarySearchTree() {

    }

    public int book(int start, int end) {
        this.root = insert(root, start, 1);
        this.root = insert(root, end, -1);
        this.cur = this.count = 0;
        count(root);
        return count;
    }

    private void count(BSTNode node) {
        if (node == null)
            return;

        count(node.left);
        cur += node.value;
        count = Math.max(count, cur);
        count(node.right);
    }

    private BSTNode insert(BSTNode node, int key, int value) {
        if (node == null) {
            node = new BSTNode(key, value);
            return node;
        } else if (node.key == key) {
            node.value += value;
        } else if (node.key < key) {
            node.right = insert(node.right, key, value);
        } else {
            node.left = insert(node.left, key, value);
        }
        return node;
    }

    private class BSTNode {
        protected int key, value;
        protected BSTNode left, right;

        protected BSTNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}