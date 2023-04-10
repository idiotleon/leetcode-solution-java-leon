/**
 * https://leetcode.com/problems/binary-watch/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/binary-watch/discuss/88456/3ms-Java-Solution-Using-Backtracking-and-Idea-of-%22Permutation-and-Combination%22
 */
package com.idiotleon.leetcode.lvl3.lc0401;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (num < 0)
            return ans;

        final int[] HOURS = { 1, 2, 4, 8 }, MINUTES = { 1, 2, 4, 8, 16, 32 };
        // pruning: HOURS, as candidates, only has 4 elements
        for (int i = 0; i <= Math.min(4, num); i++) {
            // pruning: MINUTES, as candidates, only has 6 elements
            if (num - i > 6)
                continue;
            List<Integer> hours = generateDigit(HOURS, i);
            List<Integer> minutes = generateDigit(MINUTES, num - i);
            for (int hour : hours) {
                if (hour > 11)
                    continue;
                for (int minute : minutes) {
                    if (minute > 59)
                        continue;
                    ans.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }

            }
        }

        return ans;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<Integer>();
        backtrack(nums, count, 0, 0, res);
        return res;
    }

    private void backtrack(final int[] nums, int count, int idx, int sum, List<Integer> res) {

        if (count == 0) {
            res.add(sum);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            backtrack(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }
}