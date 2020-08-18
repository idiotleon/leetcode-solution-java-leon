/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 * 
 * Time Complexities:   O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-query-mutable/discuss/75724/17-ms-Java-solution-with-segment-tree
 *  https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 */
package com.zea7ot.leetcode.lvl4.lc0307;

public class SolutionApproach0SegmentTree {
    private SegmentTreeNode root;

    public SolutionApproach0SegmentTree(int[] nums) {
        final int N = nums.length;
        this.root = buildTree(0, N - 1, nums);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.end == end && node.start == start)
            return node.sum;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if (end <= mid)
                return sumRange(node.left, start, end);
            else if (start >= mid + 1)
                return sumRange(node.right, start, end);
            else
                return sumRange(node.right, mid + 1, end) + sumRange(node.left, start, mid);
        }
    }

    private void update(SegmentTreeNode node, int pos, int val) {
        if (node.start == node.end)
            node.sum = val;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid)
                update(node.left, pos, val);
            else
                update(node.right, pos, val);
            node.sum = node.left.sum + node.right.sum;
        }
    }

    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end)
            return null;
        else {
            SegmentTreeNode node = new SegmentTreeNode(start, end);
            if (start == end)
                node.sum = nums[start];
            else {
                int mid = start + (end - start) / 2;
                node.left = buildTree(start, mid, nums);
                node.right = buildTree(mid + 1, end, nums);
                node.sum = node.left.sum + node.right.sum;
            }

            return node;
        }
    }

    private class SegmentTreeNode {
        protected int start, end;
        protected SegmentTreeNode left, right;
        protected int sum;

        protected SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.sum = 0;
        }
    }
}