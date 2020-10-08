/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/discuss/463306/JavaC%2B%2BPython-Just-Sort-O(nlogn)
 */
package com.zea7ot.leetcode.lvl4.lc1300;

import java.util.Arrays;

public class SolutionApproach1Sorting {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        final int L = arr.length;
        int i = 0;

        while (i < L && target > arr[i] * (L - 1)) {
            target -= arr[i++];
        }

        if (i == L)
            return arr[L - 1];

        int ans = target / (L - i);

        if (target - ans * (L - i) > (ans + 1) * (L - i) - target) {
            ans++;
        }

        return ans;
    }
}