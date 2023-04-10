/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * the description of the problem guarantees that there always will be a majority element
 * 
 * References:
 *  https://leetcode.com/problems/majority-element/discuss/51613/O(n)-time-O(1)-space-fastest-solution
 *  https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
 */
package com.idiotleon.leetcode.lvl3.lc0169;

public class SolutionApproach0MooreVotingAlgorithm {
    public int majorityElement(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;

        int major = nums[0], count = 1;
        for (int i = 1; i < N; ++i) {
            if (count == 0) {
                ++count;
                major = nums[i];
            } else if (major == nums[i])
                ++count;
            else
                --count;
        }

        return major;
    }
}
