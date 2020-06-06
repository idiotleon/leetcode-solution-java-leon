/**
 * https://leetcode.com/problems/create-maximum-number/
 * 
 * https://youtu.be/YYduNJfzWaA
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-321-create-maximum-number/
 * 
 * to turn the problem into 2 subproblems, 
 * both of which are solved by greedy algorithm
 * 
 * Time Complexity: O(k *(n1 + n2) ^ 2)
 * Space Complexity: O(n1 + n2)
 */
package com.zea7ot.lc.lvl4.lc0321;

public class SolutionApproachGreedyAndDP {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[0];
        for(int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); ++i){
            best = max(best, 0, maxNumber(maxNumber(nums1, i), maxNumber(nums2, k - i)), 0);
        }
        
        return best;
    }
    
    // given an array, take the first k largest element, with the orders maintained
    private int[] maxNumber(int[] nums, int k){
        int[] ans = new int[k];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            while(j > 0 && nums[i] > ans[j - 1] && nums.length - i > k - j)
                --j;
            
            if(j < k){
                ans[j++] = nums[i];
            }
        }
        
        return ans;
    }
    
    // to merge two arrays
    private int[] maxNumber(int[] nums1, int[] nums2){
        int[] ans = new int[nums1.length + nums2.length];
        int idx1 = 0, idx2 = 0;
        int index = 0;
        while(idx1 != nums1.length || idx2 != nums2.length){
            ans[index++] = max(nums1, idx1, nums2, idx2) == nums1 ? nums1[idx1++] : nums2[idx2++];
        }
        
        return ans;
    }
    
    // helper method, to get the larger element at given index, in the arrays
    private int[] max(int[] nums1, int idx1, int[] nums2, int idx2){
        for(int i = idx1; i < nums1.length; i++){
            int j = idx2 + i - idx1;
            if(j >= nums2.length) return nums1;
            if(nums1[i] < nums2[j]) return nums2;
            if(nums1[i] > nums2[j]) return nums1;
        }
        
        return nums2;
    }
}