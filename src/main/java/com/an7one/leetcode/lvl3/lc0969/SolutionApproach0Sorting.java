/**
 * https://leetcode.com/problems/pancake-sorting/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/pancake-sorting/discuss/214200/Java-flip-the-largest-number-to-the-tail
 */
package com.an7one.leetcode.lvl3.lc0969;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Sorting {
    public List<Integer> pancakeSort(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        int len = N;
        for (int i = 0; i < N; ++i) {
            int index = find(len, nums);
            pancakeFlip(index, nums);
            pancakeFlip(len - 1, nums);
            ans.add(index + 1);
            ans.add(len);
            --len;
        }

        return ans;
    }

    private int find(int target, int[] nums) {
        final int N = nums.length;
        for (int i = 0; i < N; ++i) {
            if (nums[i] == target)
                return i;
        }

        return -1;
    }

    private void pancakeFlip(int index, int[] nums) {
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