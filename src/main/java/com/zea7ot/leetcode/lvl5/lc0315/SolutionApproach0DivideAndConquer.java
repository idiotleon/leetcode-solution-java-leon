/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76674/3-Ways-(Segment-Tree-Binary-Indexed-Tree-Merge-Sort)-clean-Java-code
 */
package com.zea7ot.leetcode.lvl5.lc0315;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DivideAndConquer {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return ans;

        final int L = nums.length;

        int[] idxes = new int[L];
        int[] counts = new int[L];

        for (int i = 0; i < L; i++) {
            idxes[i] = i;
        }

        mergeSort(nums, idxes, 0, L, counts);

        for (int count : counts)
            ans.add(count);

        return ans;
    }

    private void mergeSort(int[] nums, int[] idxes, int start, int end, int[] count) {
        if (start + 1 >= end)
            return;

        int mid = start + (end - start) / 2;
        mergeSort(nums, idxes, start, mid, count);
        mergeSort(nums, idxes, mid, end, count);

        merge(nums, idxes, start, end, count);
    }

    private void merge(int[] nums, int[] idxes, int start, int end, int[] count) {
        int mid = start + (end - start) / 2;

        int[] temp = new int[end - start];
        int[] tempIdx = new int[end - start];

        int i = start, j = mid, k = 0;
        while (k < end - start) {
            if (i < mid) {
                if (j < end && nums[j] < nums[i]) {
                    tempIdx[k] = idxes[j];
                    temp[k++] = nums[j++];
                } else {
                    count[idxes[i]] += j - mid;
                    tempIdx[k] = idxes[i];
                    temp[k++] = nums[i++];
                }
            } else {
                tempIdx[k] = idxes[j];
                temp[k++] = nums[j++];
            }
        }

        System.arraycopy(tempIdx, 0, idxes, start, end - start);
        System.arraycopy(temp, 0, nums, start, end - start);
    }
}