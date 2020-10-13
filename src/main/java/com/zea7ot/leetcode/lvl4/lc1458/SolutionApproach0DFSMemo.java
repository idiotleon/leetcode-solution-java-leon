package com.zea7ot.leetcode.lvl4.lc1458;

public class SolutionApproach0DFSMemo {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;
        Integer[][] memo = new Integer[N1][N2];
        return dfs(N1 - 1, nums1, N2 - 1, nums2, memo);
    }

    private int dfs(int idx1, int[] nums1, int idx2, int[] nums2, Integer[][] memo) {
        // not used
        // final int N1 = nums1.length, N2 = nums2.length;
        if (idx1 < 0 || idx2 < 0)
            return 0;
        if (memo[idx1][idx2] != null)
            return memo[idx1][idx2];

        int largest = nums1[idx1] * nums2[idx2];
        if (idx1 > 0 && idx2 > 0)
            largest = Math.max(largest, largest + dfs(idx1 - 1, nums1, idx2 - 1, nums2, memo));
        if (idx1 > 0)
            largest = Math.max(largest, dfs(idx1 - 1, nums1, idx2, nums2, memo));
        if (idx2 > 0)
            largest = Math.max(largest, dfs(idx1, nums1, idx2 - 1, nums2, memo));
        return memo[idx1][idx2] = largest;
    }
}
