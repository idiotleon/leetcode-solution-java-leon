/**
 * https://leetcode.com/problems/sort-transformed-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/sort-transformed-array/discuss/83322/Java-O(n)-incredibly-short-yet-easy-to-understand-AC-solution/237533
 *  https://leetcode.com/problems/sort-transformed-array/discuss/83322/Java-O(n)-incredibly-short-yet-easy-to-understand-AC-solution
 */
package com.an7one.leetcode.lvl3.lc0360;

public class SolutionApproach0TwoPointers {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        final int N = nums.length;
        for (int i = 0; i < N; ++i)
            nums[i] = nums[i] * nums[i] * a + nums[i] * b + c;

        int[] ans = new int[N];
        int lo = 0, hi = N - 1;

        if (a > 0) {
            // valley
            int idx = N - 1;
            while (idx >= 0) {
                ans[idx--] = nums[lo] > nums[hi] ? nums[lo++] : nums[hi--];
            }
        } else {
            // peak
            int idx = 0;
            while (idx < N) {
                ans[idx++] = nums[lo] < nums[hi] ? nums[lo++] : nums[hi--];
            }
        }

        return ans;
    }
}