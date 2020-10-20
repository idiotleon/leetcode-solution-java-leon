/**
 * https://leetcode.com/problems/summary-ranges/
 * 
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 * 
 * References:
 *  https://leetcode.com/problems/summary-ranges/discuss/63219/Accepted-JAVA-solution-easy-to-understand
 */
package com.zea7ot.leetcode.lvl3.lc0228;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0ParsingString {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        // sanity check
        if (nums == null || nums.length == 0)
            return ans;

        final int N = nums.length;
        int idx = 0;
        while (idx < N) {
            int cur = nums[idx];
            while (idx + 1 < N && (nums[idx + 1] - nums[idx] == 1)) {
                ++idx;
            }

            if (cur != nums[idx]) {
                ans.add(cur + "->" + nums[idx]);
            } else {
                ans.add(String.valueOf(cur));
            }

            ++idx;
        }

        return ans;
    }
}