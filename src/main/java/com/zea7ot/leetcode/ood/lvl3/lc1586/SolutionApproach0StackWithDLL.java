/**
 * https://leetcode.com/problems/binary-search-tree-iterator-ii/
 * 
 * Time Complexities:
 * 
 * Space Complexities:
 * 
 * 
 * References:
 *  https://leetcode.com/problems/binary-search-tree-iterator-ii/discuss/857055/java-stack-%2B-linkedList-100
 */
package com.zea7ot.leetcode.ood.lvl3.lc1586;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0StackWithDLL {
    private Deque<TreeNode> stack;
    private DoublyLinkedList dll;
    private DLLNode cur;

    public SolutionApproach0StackWithDLL(TreeNode root) {
        this.stack = new ArrayDeque<>();
        this.dll = new DoublyLinkedList();
        this.cur = dll.dummyHead;

        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return cur.next != dll.dummyTail || !stack.isEmpty();
    }

    public int next() {
        if (cur.next != dll.dummyTail) {
            cur = cur.next;
            return cur.val;
        }

        if (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            int val = top.val;

            top = top.right;
            while (top != null) {
                stack.push(top);
                top = top.left;
            }

            DLLNode node = new DLLNode(val);
            dll.addLast(node);
            cur = node;
            return val;

        } else
            return -1;
    }

    public boolean hasPrev() {
        return cur != dll.dummyHead && cur.prev != dll.dummyHead;
    }

    public int prev() {
        if (hasPrev()) {
            cur = cur.prev;
            return cur.val;

        } else
            return -1;
    }

    private class DoublyLinkedList {
        private DLLNode dummyHead, dummyTail;

        private DoublyLinkedList() {
            this.dummyHead = new DLLNode(-1);
            this.dummyTail = new DLLNode(-1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        private void addLast(DLLNode node) {
            DLLNode prev = this.dummyTail.prev;

            prev.next = node;
            node.prev = prev;

            node.next = dummyTail;
            dummyTail.prev = node;
        }
    }

    private class DLLNode {
        private int val;
        private DLLNode prev, next;

        private DLLNode(int val) {
            this.val = val;
            this.prev = this.next = null;
        }
    }
}
