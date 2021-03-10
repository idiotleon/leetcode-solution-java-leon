/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Time Complexity: 
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.an7one.leetcode.lvl5.lc0315;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0SegmentedTree {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int L = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        SegTreeNode root = new SegTreeNode(min, max);
        for (int i = L - 1; i >= 0; i--) {
            // to minus 1, in case there will be an equal one
            ans.add(0, find(nums[i] - 1, root));
            add(nums[i], root);
        }

        return ans;
    }

    private void add(int num, SegTreeNode node) {
        if (num < node.min || num > node.max)
            return;

        node.count++;
        if (node.max == node.min)
            return;

        int mid = node.getMid();
        if (num < mid) {
            if (node.left == null) {
                node.left = new SegTreeNode(node.min, mid - 1);
            }
            add(num, node.left);
        } else {
            if (node.right == null) {
                node.right = new SegTreeNode(mid, node.max);
            }
            add(num, node.right);
        }
    }

    private int find(int num, SegTreeNode node) {
        if (node == null)
            return 0;

        if (num >= node.max)
            return node.count;
        else {
            int mid = node.getMid();
            if (num < mid)
                return find(num, node.left);
            else
                return find(num, node.left) + find(num, node.right);
        }
    }

    private class SegTreeNode {
        protected int min, max;
        protected int count;
        protected SegTreeNode left, right;

        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            this.count = 0;
        }

        public int getMid() {
            return min + (max + 1 - min) / 2;
        }
    }
}