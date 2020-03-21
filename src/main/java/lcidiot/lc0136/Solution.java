/**
 * https://leetcode.com/problems/single-number/
 */
package main.java.lcidiot.lc0136;

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}