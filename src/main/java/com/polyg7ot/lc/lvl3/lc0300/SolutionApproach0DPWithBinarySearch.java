/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
 * 
 * tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
 * 
 * Each time we only do one of the two:
 * (1) if num is larger than all tails, append it, increase the size by 1
 * (2) if tails[i - 1] < num <= tails[i], update tails[i]
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
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
 *  1. if num is larger than all tails, to append it, and to increase the size by 1
 *  2. if tails[i - 1] < x <= tails[i], to update tails[i]
 * 
 * 
 * References:
 *  https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
 */
package com.polyg7ot.lc.lvl3.lc0300;

public class SolutionApproach0DPWithBinarySearch {
    public int lengthOfLIS(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return 0;

        final int N = nums.length;
        int[] tails = new int[N];
        int size = 0;
        for(int num : nums){
            int lo = 0, hi = size;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(tails[mid] < num){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }
            tails[lo] = num;
            if(lo == size){
                ++size;
            }
        }
        
        return size;
    }
}