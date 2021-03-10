/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Time Complexity:     O(`N` * lg(`N`)) + O(`N`) ~ O(`N` * lg(`N`))
 * Space Complexity:    O(`N`) + O(`max`)
 * 
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.an7one.leetcode.lvl5.lc0315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0BinaryIndexedTree {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int[] nums2 = new int[N];
        for (int i = 0; i < N; ++i) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i], max);
        }

        int[] bit = new int[max + 1];
        for (int i = N - 1; i >= 0; --i) {
            ans.add(get(nums2[i] - 1, bit));
            update(nums2[i], bit);
        }

        Collections.reverse(ans);
        return ans;
    }

    private int get(int idx, int[] bit) {
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & (-idx);
        }

        return sum;
    }

    private void update(int idx, int[] bit) {
        final int N = bit.length;
        while (idx < N) {
            ++bit[idx];
            idx += idx & (-idx);
        }
    }
}