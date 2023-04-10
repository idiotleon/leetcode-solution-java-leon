/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(32) ~ O(1)
 * 
 * the description of the problem guarantees that there always will be a majority element
 * 
 * References:
 *  https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
package com.idiotleon.leetcode.lvl3.lc0169;

public class SolutionApproach0BitManipulation {
    public int majorityElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int[] bit = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; ++i)
                if ((num >> (31 - i) & 1) == 1)
                    ++bit[i];

        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            bit[i] = bit[i] > N / 2 ? 1 : 0;
            ans += bit[i] * (1 << (31 - i));
        }

        return ans;
    }
}
