/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Time Complexity:     O(N1 + N2)
 * Space Complexity:    O(N1 + N2)
 * 
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
 */
package com.an7one.leetcode.lvl1.lc0349;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public int[] intersection(int[] nums1, int[] nums2) {
        // not used
        // final int N1 = nums1.length, N2 = nums2.length;

        Set<Integer> seenOnce = new HashSet<>();
        Set<Integer> seenTwice = new HashSet<>();

        for (int num : nums1) {
            seenOnce.add(num);
        }

        for (int num : nums2) {
            if (seenOnce.contains(num)) {
                seenTwice.add(num);
            }
        }

        int[] ans = new int[seenTwice.size()];
        int idx = 0;
        for (int num : seenTwice) {
            ans[idx++] = num;
        }

        return ans;
    }
}