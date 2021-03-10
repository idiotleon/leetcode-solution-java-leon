/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * to use previously established next pointers
 */
package com.an7one.leetcode.lvl3.lc0116;

public class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;

            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }
}