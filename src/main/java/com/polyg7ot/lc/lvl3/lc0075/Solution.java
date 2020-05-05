/**
 * https://leetcode.com/problems/sort-colors/
 */
package com.polyg7ot.lc.lvl3.lc0075;

public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, cur = 0, p2 = nums.length - 1, temp;
        while(cur <= p2){
            if(nums[cur] == 0){
                temp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = temp;
            }else if(nums[cur] == 2){
                temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = temp;
            }else cur++;
        }
    }
}