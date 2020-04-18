/**
 * https://leetcode.com/problems/continuous-subarray-sum/submissions/
 * 
 * https://leetcode.com/problems/continuous-subarray-sum/discuss/99506/Concise-C%2B%2B-solution-use-set-instead-of-map
 * 
 * Steps:
 *  1. to store mod result in a set
 *  2. to delay the storing by 1 loop so that the length subarray of is > 1
 */
package main.java.lcidiot.lc0523;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproachSet {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0, pre = 0;
        Set<Integer> modk = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int mod = k == 0 ? sum : sum % k;
            if(modk.contains(mod)) return true;
            modk.add(pre);
            pre = mod;
        }
        return false;
    }
}