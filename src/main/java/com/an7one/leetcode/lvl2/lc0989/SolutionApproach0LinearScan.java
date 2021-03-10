/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1) / O(N)
 * 
 * References:
 *  https://leetcode.com/problems/add-to-array-form-of-integer/discuss/234488/JavaC++Python-Take-K-itself-as-a-Carry/236242
 *  https://leetcode.com/problems/add-to-array-form-of-integer/discuss/234488/JavaC%2B%2BPython-Take-K-itself-as-a-Carry
 */
package com.an7one.leetcode.lvl2.lc0989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionApproach0LinearScan {
    public List<Integer> addToArrayForm(int[] nums, int K) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if (nums == null)
            return ans;

        final int N = nums.length;
        for (int i = N - 1; i >= 0; --i) {
            int sum = nums[i] + K;
            ans.add(sum % 10);
            K = sum / 10;
        }

        while (K > 0) {
            ans.add(K % 10);
            K /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}