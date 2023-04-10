/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 * 
 * Time Complexities:   
 *  `update()`:     O(lg(N))
 *  `sumRange()`:   O(lg(N) + k)
 *      k, 
 * 
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-query-mutable/discuss/75724/17-ms-Java-solution-with-segment-tree
 *  https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 */
package com.idiotleon.leetcode.ood.lvl4.lc0307;

public class SolutionApproach0SegmentTree1 {
    private SegmentTreeNode root;

    public SolutionApproach0SegmentTree1(int[] nums) {
        final int N = nums.length;
        this.root = buildTree(0, N - 1, nums);
    }

    public void update(int i, int val) {
        update(i, val, root);
    }

    public int sumRange(int i, int j) {
        return rangeQuery(i, j, root);
    }

    private int rangeQuery(int start, int end, SegmentTreeNode node) {
        if (node.end == end && node.start == start)
            return node.sum;

        int mid = node.start + (node.end - node.start) / 2;
        if (end <= mid)
            return rangeQuery(start, end, node.left);
        else if (start >= mid + 1)
            return rangeQuery(start, end, node.right);
        else
            return rangeQuery(mid + 1, end, node.right) + rangeQuery(start, mid, node.left);
    }

    private void update(int pos, int val, SegmentTreeNode node) {
        if (node.start == node.end)
            node.sum = val;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid)
                update(pos, val, node.left);
            else
                update(pos, val, node.right);

            node.sum = node.left.sum + node.right.sum;
        }
    }

    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end)
            return null;

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