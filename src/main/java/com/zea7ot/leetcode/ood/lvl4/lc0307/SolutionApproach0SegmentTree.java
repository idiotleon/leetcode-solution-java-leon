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
package com.zea7ot.leetcode.ood.lvl4.lc0307;

public class SolutionApproach0SegmentTree {
    private SegmentTree root;

    public SolutionApproach0SegmentTree(int[] nums) {
        this.root = new SegmentTree(nums);
    }

    public void update(int i, int val) {
        this.root.update(i, val);
    }

    public int sumRange(int i, int j) {
        return this.root.rangeQuery(i, j);
    }

    private class SegmentTree {
        private SegmentTreeNode root;

        private SegmentTree(int[] nums) {
            final int N = nums.length;
            this.root = buildTree(0, N - 1, nums);
        }

        private int rangeQuery(int start, int end) {
            return rangeQuery(start, end, root);
        }

        private int rangeQuery(int start, int end, SegmentTreeNode node) {
            if (node.end == end && node.start == start)
                return node.sum;

            int mid = node.start + (node.end - node.start) / 2;
            if (end <= mid) {
                return rangeQuery(start, end, node.left);
            } else if (start >= mid + 1) {
                return rangeQuery(start, end, node.right);
            } else {
                return rangeQuery(mid + 1, end, node.right) + rangeQuery(start, mid, node.left);
            }
        }

        private void update(int pos, int val) {
            update(pos, val, root);
        }

        private void update(int pos, int val, SegmentTreeNode node) {
            if (node.start == node.end) {
                node.sum = val;
                return;
            }

            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid) {
                update(pos, val, node.left);
            } else {
                update(pos, val, node.right);
            }

            node.sum = node.left.sum + node.right.sum;
        }

        private SegmentTreeNode buildTree(int start, int end, int[] nums) {
            if (start > end) {
                return null;
            }

            SegmentTreeNode root = new SegmentTreeNode(start, end);
            if (start == end) {
                root.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                root.left = buildTree(start, mid, nums);
                root.right = buildTree(mid + 1, end, nums);
                root.sum = root.left.sum + root.right.sum;
            }

            return root;
        }
    }

    private class SegmentTreeNode {
        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;

        private SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
            this.sum = 0;
        }
    }
}