/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * 
 * Time Complexity: O(N * lg(N) + N * lg(d))
 *  Sorting,        costs O(N * lg(N))
 *  Binary Search,  costs O(N * lg(d)), with d meaning the search space, distances
 * 
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-"trial-and-error"-algorithm/311780
 *  https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm
 */
package com.zea7ot.lc.lvl4.lc0719;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionApproach0BinarySearchWithMonoDeque {
    public int smallestDistancePair(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0 || k <= 0) return 0;

        Arrays.sort(nums);        
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while(left <= right){
            int mid = left + (right - left) / 2;
            int num = numsOfSmallerDist(nums, mid);
            if(k > num) left = mid + 1;
            else right = mid - 1;
        }
        
        return left;
    }
    
    private int numsOfSmallerDist(int[] nums, int dist){
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int ans = 0;
        
        for(int num : nums){
            while(!deque.isEmpty() && num - deque.peekFirst() > dist){
                deque.removeFirst();
                ans += deque.size();
            }
            
            deque.addLast(num);
        }
        
        while(!deque.isEmpty()){
            deque.removeFirst();
            ans += deque.size();
        }
        
        return ans;
    }
}