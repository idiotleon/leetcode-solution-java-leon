/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * follow up:
 *  can you solve it with O(1) space?
 * 
 * References:
 *  https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/92387/Java-Simple-Solution
 */
package com.zea7ot.leetcode.lvl4.lc0442;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0HashMap {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        for(int i = 0; i < N; ++i){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0)
                ans.add(idx + 1);
            nums[idx] = -nums[idx];
        }
        
        return ans;
    }
}