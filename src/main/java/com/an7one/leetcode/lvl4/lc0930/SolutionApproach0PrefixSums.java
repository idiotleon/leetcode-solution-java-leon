/**
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space
 */
package com.an7one.leetcode.lvl4.lc0930;

public class SolutionApproach0PrefixSums {
    public int numSubarraysWithSum(int[] nums, int S) {
        // sanity check
        if (nums == null || nums.length < S || S < 0)
            return 0;

        final int L = nums.length;
        int count = 0;

        int[] freq = new int[L + 1];
        freq[0] = 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (sum >= S)
                count += freq[sum - S];

            ++freq[sum];
        }

        return count;
    }
}