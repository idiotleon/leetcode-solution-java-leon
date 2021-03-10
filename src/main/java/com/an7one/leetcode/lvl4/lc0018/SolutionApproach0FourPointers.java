/**
 * https://leetcode.com/problems/4sum/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N ^ 3) ~ O(N ^ 3)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA/201112
 *  https://leetcode.com/problems/4sum/discuss/8609/My-solution-generalized-for-kSums-in-JAVA/201112
 */
package com.an7one.leetcode.lvl4.lc0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0FourPointers {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < N - 3; ++i) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            for (int j = i + 1; j < N - 2; ++j) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;
                int lo = j + 1, hi = N - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        ++lo;
                        --hi;

                        while (lo < hi && nums[lo - 1] == nums[lo])
                            ++lo;
                        while (lo < hi && nums[hi] == nums[hi + 1])
                            --hi;
                    } else if (sum < target)
                        ++lo;
                    else
                        --hi;
                }
            }
        }

        return ans;
    }
}