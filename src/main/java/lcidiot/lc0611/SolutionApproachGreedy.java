/**
 * https://leetcode.com/problems/valid-triangle-number/
 */
package main.java.lcidiot.lc0611;

import java.util.Arrays;

public class SolutionApproachGreedy {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        final int N = nums.length;
        
        for(int i = N - 1; i >= 2; i--){
            int start = 0, end = i - 1;
            while(start < end){
                if(nums[start] + nums[end] > nums[i]){
                    ans += end - start;
                    end--;
                }else{
                    start++;
                }
            }
        }
        
        return ans;
    }
}