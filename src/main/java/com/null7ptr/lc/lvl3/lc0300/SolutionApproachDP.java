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
 * Time Complexity: O(Nlg(N))
 * Space Complexity: O(N)
 */
package com.null7ptr.lc.lvl3.lc0300;

public class SolutionApproachDP {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for(int num : nums){
            int left = 0, right = size;
            while(left != right){
                int mid = left + (right - left) / 2;
                if(tails[mid] < num){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            tails[left] = num;
            if(left == size){
                ++size;
            }
        }
        
        return size;
    }
}