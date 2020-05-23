/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * 
 * Time Complexity: O(N * lg(d) + N * lg(N))
 *  Sorting,        costs O(N * lg(N))
 *  Binary Search,  costs O(N * lg(d)), with d meaning the search space, distances
 * 
 * Space Complexity: O(1)
 * 
 * 
 * "You probably will wonder why we throw away the right half of the search space even if count(m) == K. 
 * Note that the K-th smallest pair distance num_k is the minimum integer such that count(num_k) >= K. 
 * If count(m) == K, then we know num_k <= m (but not necessarily num_k == m, think about it!),
 * so it makes no sense keeping the right half."
 * 
 * References:
 *  https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
 */
package com.polyg7ot.lc.lvl4.lc0719;

import java.util.Arrays;

public class SolutionApproach0BinarySearch {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        final int N = nums.length;
        int left = 0, right = nums[N - 1] - nums[0];
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            int count = getCount(nums, mid);
            if(k > count) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
    
    private int getCount(int[] nums, int target){
        final int N = nums.length;
        int count = 0;
        for(int i = 0, j = 0; i < N; i++){
            while(j < N && nums[j] <= nums[i] + target) j++;
            count += j - i - 1;
        }
        
        return count;
    }
}