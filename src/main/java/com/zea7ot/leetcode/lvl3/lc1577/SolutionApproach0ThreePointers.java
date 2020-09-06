/**
 * https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 * 
 * Time Complexity:     O(N1 * lg(N1)) + O(N2 * lg(N2)) + O(N1 ^ 2) + O(N2 ^ 2) ~ O(max(N1, N2) ^ 2)
 * Space Complexity:    O(N1 + N2) ~ O(max(N1, N2))
 */
package com.zea7ot.leetcode.lvl3.lc1577;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0ThreePointers {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq1 = new HashMap<>();
        for (int num : nums1)
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);

        Map<Integer, Integer> freq2 = new HashMap<>();
        for (int num : nums2)
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return getCount(freq2, nums1, nums2) + getCount(freq1, nums2, nums1);
    }

    private int getCount(Map<Integer, Integer> freq, int[] nums1, int[] nums2) {
        final int N1 = nums1.length;
        final int N2 = nums2.length;

        int count = 0;
        for (int i = 0; i < N1; ++i) {
            long target = 1L * nums1[i] * nums1[i];

            int lo = 0, hi = N2 - 1;
            while (lo < hi) {
                long multi = 1L * nums2[lo] * nums2[hi];
                if (multi > target)
                    --hi;
                else if (multi < target)
                    ++lo;
                else {
                    int f1 = freq.get(nums2[lo]);
                    int f2 = freq.get(nums2[hi]);

                    if (nums2[lo] != nums2[hi])
                        count += f1 * f2;

                    if (nums2[lo] == nums2[hi])
                        count += f1 * (f1 - 1) / 2;

                    --hi;
                    while (lo < hi && nums2[hi] == nums2[hi + 1])
                        --hi;
                    ++lo;
                    while (lo < hi && nums2[lo - 1] == nums2[lo])
                        ++lo;
                }
            }
        }

        return count;
    }
}
