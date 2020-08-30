/**
 * https://leetcode.com/problems/pancake-sorting/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/pancake-sorting/discuss/214213/JavaC++Python-Straight-Forward/388093
 *  https://leetcode.com/problems/pancake-sorting/discuss/214213/JavaC%2B%2BPython-Straight-Forward
 */
package com.zea7ot.leetcode.lvl3.lc0969;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Sorting1 {
    public List<Integer> pancakeSort(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;

        int len = N;
        while (len > 1) {
            int max = nums[0], index = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    index = i;
                }
            }

            if (index == len - 1) {
                --len;
                continue;
            }

            ans.add(index + 1);
            pancakeFlip(nums, index + 1);
            ans.add(len);
            pancakeFlip(nums, len);
            len--;
        }

        return ans;
    }

    private void pancakeFlip(int[] nums, int index) {
        int lo = 0, hi = index;
        while (lo < hi)
            swap(lo++, hi--, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}