/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
 */
package com.idiotleon.leetcode.lvl1.lc0349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0TwoPointers {
    public int[] intersection(int[] nums1, int[] nums2) {
        final int N1 = nums1.length, N2 = nums2.length;

        List<Integer> intersections = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx1 = 0, idx2 = 0;
        while (idx1 < N1 && idx2 < N2) {
            if (nums1[idx1] < nums2[idx2]) {
                ++idx1;
            } else if (nums1[idx1] > nums2[idx2]) {
                ++idx2;
            } else {
                int same = nums1[idx1];
                intersections.add(nums1[idx1]);

                while (idx1 < N1 && nums1[idx1] == same) {
                    ++idx1;
                }

                while (idx2 < N2 && nums2[idx2] == same) {
                    ++idx2;
                }
            }
        }

        int[] ans = new int[intersections.size()];
        int idx = 0;
        for (int num : intersections) {
            ans[idx++] = num;
        }

        return ans;
    }
}