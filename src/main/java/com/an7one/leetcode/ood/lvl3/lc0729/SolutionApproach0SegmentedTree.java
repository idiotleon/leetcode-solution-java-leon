/**
 * https://leetcode.com/problems/my-calendar-i/
 * 
 * Time Complexity:     O(N * lg(`RANGE`))
 * Space Complexity:    O(N * lg(`RANGE`))
 * 
 * References:
 *  https://leetcode.com/problems/my-calendar-ii/discuss/109528/nlogd-Java-solution-using-segment-tree-with-lazy-propagation-(for-the-general-case-of-K-booking)
 */
package com.an7one.leetcode.ood.lvl3.lc0729;

public class SolutionApproach0SegmentedTree {
    private SegmentedTreeNode root;

    public SolutionApproach0SegmentedTree() {
        final int RANGE = (int) 1e9;
        this.root = new SegmentedTreeNode(0, RANGE, 0);
    }

    public boolean book(int start, int end) {
        if (start > end)
            return false;

        int k = query(root, start, end - 1);
        // to return false if any interval occupied
        if (k > 0)
            return false;

        update(root, start, end - 1, 1);
        return true;
    }

    private int query(SegmentedTreeNode node, final int RANGE_LOW, final int RANGE_HIGH) {
        if (RANGE_LOW > RANGE_HIGH || node == null || RANGE_LOW > node.HIGH || RANGE_HIGH < node.LOW)
            return 0;

        if (RANGE_LOW <= node.LOW && node.HIGH <= RANGE_HIGH)
            return node.k;

        normalize(node);

        return Math.max(query(node.left, RANGE_LOW, RANGE_HIGH), query(node.right, RANGE_LOW, RANGE_HIGH));
    }

    private void update(SegmentedTreeNode node, final int RANGE_LOW, final int RANGE_HIGH, int val) {
        if (RANGE_LOW > RANGE_HIGH || node == null || RANGE_LOW > node.HIGH || RANGE_HIGH < node.LOW)
            return;

        if (RANGE_LOW <= node.LOW && node.HIGH <= RANGE_HIGH) {
            node.k += val;
            node.lazy += val;
            return;
        }

        normalize(node);

        update(node.left, RANGE_LOW, RANGE_HIGH, val);
        update(node.right, RANGE_LOW, RANGE_HIGH, val);

        node.k = Math.max(node.left.k, node.right.k);
    }

    private void normalize(SegmentedTreeNode node) {
        if (node.LOW < node.HIGH) {
            if (node.left == null || node.right == null) {
                final int MID = node.LOW + (node.HIGH - node.LOW) / 2;

                node.left = new SegmentedTreeNode(node.LOW, MID, node.k);
                node.right = new SegmentedTreeNode(MID + 1, node.HIGH, node.k);
            } else if (node.lazy > 0) {
                node.left.k += node.lazy;
                node.right.lazy = node.lazy;

                node.right.k += node.lazy;
                node.right.lazy += node.lazy;
            }
        }

        node.lazy = 0;
    }

    private class SegmentedTreeNode {
        private final int LOW, HIGH;
        private int k, lazy;
        private SegmentedTreeNode left, right;

        private SegmentedTreeNode(final int LOW, final int HIGH, int k) {
            this.LOW = LOW;
            this.HIGH = HIGH;
            this.k = k;
            this.left = this.right = null;
        }
    }
}