/**
 * https://leetcode.com/problems/sliding-window-median/
 * 
 * Time Complexity:     O(N * lg(k))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)/538502
 *  https://leetcode.com/problems/sliding-window-median/discuss/96346/Java-using-two-Tree-Sets-O(n-logk)
 */
package com.an7one.leetcode.lvl5.lc0480;

import java.util.TreeSet;

public class SolutionApproach0TreeSets {
    public double[] medianSlidingWindow(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0 || k <= 0)
            return new double[0];
        final int N = nums.length;
        double[] ans = new double[N];

        TreeSet<Integer> lo = new TreeSet<Integer>(
                (a, b) -> nums[a] == nums[b] ? Integer.compare(b, a) : Integer.compare(nums[b], nums[a]));
        TreeSet<Integer> hi = new TreeSet<Integer>(
                (a, b) -> nums[a] == nums[b] ? Integer.compare(a, b) : Integer.compare(nums[a], nums[b]));

        for (int i = 0; i < k; ++i)
            lo.add(i);
        balance(lo, hi);
        ans[0] = getMedian(lo, hi, k, nums);

        int idx = 1;
        for (int i = k; i < N; ++i) {
            if (!lo.remove(i - k))
                hi.remove(i - k);

            hi.add(i);
            lo.add(hi.pollFirst());
            balance(lo, hi);
            ans[idx++] = getMedian(lo, hi, k, nums);
        }

        return ans;
    }

    private void balance(TreeSet<Integer> lo, TreeSet<Integer> hi) {
        while (lo.size() > hi.size())
            hi.add(lo.pollFirst());
    }

    private double getMedian(TreeSet<Integer> lo, TreeSet<Integer> hi, int k, int[] nums) {
        if (k % 2 == 0)
            return ((double) nums[lo.first()] + (double) nums[hi.first()]) / 2;
        else
            return (double) nums[hi.first()];
    }
}