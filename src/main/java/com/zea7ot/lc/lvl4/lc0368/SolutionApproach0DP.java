/**
 * https://leetcode.com/problems/largest-divisible-subset/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/largest-divisible-subset/discuss/83999/Easy-understood-Java-DP-solution-in-28ms-with-O(n2)-time
 */
package com.zea7ot.lc.lvl4.lc0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DP {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        
        // to find the length of largest subset it has
        for(int i = 1; i < N; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j + 1]);
                }
            }
        }
        
        // to pick the index of hte largest element in dp(int[])
        int maxIndex = 0;
        for(int i = 1; i < N; i++){
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
        
        // from nums[maxIndex] to 0, to add every element which belongs to the largest subset
        int temp = nums[maxIndex];
        int curDp = dp[maxIndex];
        for(int i = maxIndex; i >= 0; i--){
            if(temp % nums[i] == 0 && dp[i] == curDp){
                ans.add(nums[i]);
                temp = nums[i];
                curDp--;
            }
        }
        
        return ans;
    }
}