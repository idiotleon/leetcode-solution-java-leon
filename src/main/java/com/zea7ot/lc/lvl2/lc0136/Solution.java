/**
 * https://leetcode.com/problems/single-number/
 */
package com.zea7ot.lc.lvl2.lc0136;

public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}