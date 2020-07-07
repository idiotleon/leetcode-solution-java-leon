/**
 * https://leetcode.com/problems/continuous-subarray-sum/submissions/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * https://leetcode.com/problems/continuous-subarray-sum/discuss/99506/Concise-C%2B%2B-solution-use-set-instead-of-map
 * 
 * Steps:
 *  1. to store mod result in a set
 *  2. to delay the storing by 1 loop so that the length subarray of is > 1
 */
package com.zea7ot.lc.lvl3.lc0523;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Set {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0) return false;

        final int N = nums.length; 
        int sum = 0, prev = 0;
        Set<Integer> modk = new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if(modk.contains(mod)) return true;
            modk.add(prev);
            prev = mod;
        }
        return false;
    }
}