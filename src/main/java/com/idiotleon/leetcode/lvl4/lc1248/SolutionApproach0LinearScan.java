/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/count-number-of-nice-subarrays/discuss/419378/JavaC%2B%2BPython-Sliding-Window-O(1)-Space
 */
package com.idiotleon.leetcode.lvl4.lc1248;

public class SolutionApproach0LinearScan {
    public int numberOfSubarrays(int[] nums, int k) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        int count = 0, ans = 0;
        int lo = 0, hi = 0;

        while (hi < N) {
            if (nums[hi] % 2 == 1) {
                --k;
                count = 0;
            }

            while (k == 0) {
                k += nums[lo] & 1;
                ++count;
                ++lo;
            }

            ans += count;
            ++hi;
        }

        return ans;
    }
}