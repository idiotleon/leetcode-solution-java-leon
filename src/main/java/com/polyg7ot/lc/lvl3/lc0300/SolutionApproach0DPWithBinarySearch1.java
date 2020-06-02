/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * 
 * key steps:
 *  1. if nums[i] is smaller than the smallest tail(tails[0]), to simply update tails[0] with nums[i];
 *  2. if nums[i] is larger than the largest tail(tails[len]), to simply append it to tails(tails[++len] = nums[i]);
 *  3, if nums[i] is in the middle, to binary search the "insertion" positio (or lower bound) "idx" among tails for nums[i](num for short), 
 *      so that a LIS has a smaller tail, updated with nums[i]   
 * 
 * References:
 *  https://segmentfault.com/a/1190000003819886
 * 
 * Similar Problems
 *  2   0674    https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *  3   1048    https://leetcode.com/problems/longest-string-chain/
 *  4   0128    https://leetcode.com/problems/longest-consecutive-sequence/
 *  4   0368    https://leetcode.com/problems/largest-divisible-subset/
 *  4   0646    https://leetcode.com/problems/maximum-length-of-pair-chain/
 *  4   0673    https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *  4   0740    https://leetcode.com/problems/delete-and-earn/
 *  5   0354    https://leetcode.com/problems/russian-doll-envelopes/
 */
package com.polyg7ot.lc.lvl3.lc0300;

public class SolutionApproach0DPWithBinarySearch1 {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int len = 0;
        // tails are the last actual element/digit/number of LIS of length "len".
        // As "len" increases, tails is monotonically increasing.
        int[] tails = new int[N];
        tails[0] = nums[0];
        
        for(int i = 1; i < N; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            }else if(nums[i] > tails[len]){
                tails[++len] = nums[i];
            }else{
                tails[lowerBound(tails, 0, len, nums[i])] = nums[i];
            }
        }
        
        return len + 1;
    }
    
    private int lowerBound(int[] tails, int lo, int hi, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            // this can be omitted, at the cost of a few more iterations
            // if(tails[mid] == target) return mid;
            if(target > tails[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return lo;
    }
}