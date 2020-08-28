/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * 
 * Time Complexity:     O(`RANGE`) ~ O(1)
 * Space Complexity:    O(`RANGE`) ~ O(1)
 * 
 * References:
 *  https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/discuss/660664/100-faster-or-Java-Arrays-sort-and-equals-or-Video-Explanation
 */
package com.zea7ot.leetcode.lvl2.lc1460;

public class SolutionApproach0LinearScan {
    public boolean canBeEqual(int[] target, int[] arr) {
        // sanity check
        if (target == null || arr == null || target.length != arr.length)
            return false;

        final int RANGE = 1001;

        final int N = arr.length;
        int[] freq = new int[RANGE];
        for (int i = 0; i < N; ++i) {
            ++freq[target[i]];
            --freq[arr[i]];
        }

        for (int i = 0; i < RANGE; ++i)
            if (freq[i] != 0)
                return false;

        return true;
    }
}