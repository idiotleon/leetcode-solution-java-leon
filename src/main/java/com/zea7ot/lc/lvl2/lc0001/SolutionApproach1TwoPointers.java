/**
 * @author Leon
 * https://leetcode.com/problems/two-sum/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 */
package com.zea7ot.lc.lvl2.lc0001;

import java.util.Arrays;

public class SolutionApproach1TwoPointers {
    public int[] twoSum(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return new int[0];

        final int N = nums.length;
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; ++i)
            nodes[i] = new Node(nums[i], i);

        Arrays.sort(nodes, (a, b) -> Integer.compare(a.value, b.value));

        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int sum = nodes[lo].value + nodes[hi].value;

            if (sum > target)
                --hi;
            else if (sum < target)
                ++lo;
            else
                return new int[] { nodes[lo].index, nodes[hi].index };
        }

        return new int[] { -1, -1 };
    }

    private class Node {
        protected int value;
        protected int index;

        protected Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}