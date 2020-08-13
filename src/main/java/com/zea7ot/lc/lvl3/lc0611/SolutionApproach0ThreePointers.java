/**
 * https://leetcode.com/problems/valid-triangle-number/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N ^ 2) ~ O(N ^ 2)
 * Space Complexity:    O(1)
 * 
 * References:  
 *  https://leetcode.com/problems/valid-triangle-number/discuss/104174/Java-O(n2)-Time-O(1)-Space
 *  https://leetcode.com/problems/valid-triangle-number/discuss/128135/A-similar-O(n2)-solution-to-3-Sum
 *  https://leetcode.com/problems/valid-triangle-number/discuss/321367/java-binary-search(log(n)-*-n2
 */
package com.zea7ot.lc.lvl3.lc0611;

import java.util.Arrays;

public class SolutionApproach0ThreePointers {
    public int triangleNumber(int[] nums) {
        // sanity check
        if (nums == null || nums.length < 3)
            return 0;

        final int N = nums.length;
        Arrays.sort(nums);
        int ans = 0;

        for (int idx = N - 1; idx >= 2; --idx) {
            int lo = 0, hi = idx - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] > nums[idx]) {
                    ans += hi - lo;
                    --hi;
                } else
                    ++lo;
            }
        }

        return ans;
    }
}