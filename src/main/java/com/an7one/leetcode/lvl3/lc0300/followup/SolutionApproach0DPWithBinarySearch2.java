/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * tails(int[]) is an array storing the smallest tail(s) of all increasing subsequences with length i+1 in tails[i].
 * 
 * Each time we only do one of the two:
 * (1) if num is larger than all tails, append it, increase the len by 1
 * (2) if tails[i - 1] < num <= tails[i], update tails[i]
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * 
 * tails is an array storing the smallest tail 
 * of all increasing subsequences
 * with length (i + 1) in tails[i]
 * 
 * nums = [4, 5, 6, 3]
 * len = 1: [4], [5], [6], [3]  =>  tails[0] = 3
 * len = 2: [4, 5], [5, 6]      =>  tails[1] = 5
 * len = 3: [4, 5, 6]           =>  tails[2] = 6
 * 
 * only two main steps:
 *  1. if num is larger than all tails, to append it, and to increase the len by 1
 *  2. if tails[i - 1] < x <= tails[i], to update tails[i]
 * 
 * 
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
 *  https://www.youtube.com/watch?v=7DKFpWnaxLI&list=PLLuMmzMTgVK7vEbeHBDD42pqqG36jhuOr&index=94
 *  https://segmentfault.com/a/1190000003819886
 *  https://youtu.be/YoeWZ3ELMEk?t=481
 */
package com.an7one.leetcode.lvl3.lc0300.followup;

public class SolutionApproach0DPWithBinarySearch2 {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int[] tails = new int[N];
        int len = 0;
        for(int num : nums){
            int lo = 0, hi = len;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(tails[mid] < num){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
            tails[lo] = num;
            if(lo == len){
                ++len;
            }
        }
        
        return len;
    }
}