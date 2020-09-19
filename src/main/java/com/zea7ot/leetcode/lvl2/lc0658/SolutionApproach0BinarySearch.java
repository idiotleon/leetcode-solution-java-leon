/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * 
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 */
package com.zea7ot.leetcode.lvl2.lc0658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionApproach0BinarySearch {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int N = arr.length;
        int lo = 0, hi = N - k;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return Arrays.stream(arr, lo, hi + k).boxed().collect(Collectors.toList());
    }
}