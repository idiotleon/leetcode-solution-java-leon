/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * 
 * Time Complexity: O(N * lg(max - min) + k) ~ O(N * lg(max - min))
 * Space Complexity: O(k)
 * 
 * References:
 *  https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/260111/Binary-search-in-O(nlog(max-min)%2Bk)-beats-100
 */
package com.idiotleon.leetcode.lvl4.lc0373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0BinarySearch {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums1 == null || nums2 == null) return ans;
        final int L1 = nums1.length, L2 = nums2.length;
        // sanity check
        if(L1 * L2 == 0) return ans;
        
        int left = nums1[0] + nums2[0], right = nums1[L1 - 1] + nums2[L2 - 1];
        if(k >= L1 * L2){
            left = right;
            k = L1 * L2;
        }else{
            while(left <= right){
                int mid = left + (right - left) / 2;
                
                int count = countLessEqual(nums1, nums2, mid);
                if(k > count) left = mid + 1;
                else right = mid - 1;
            }
        }
        
        // there might be equal cases, which the k-th smallest is in the middle of
        List<List<Integer>> equal = new ArrayList<List<Integer>>();
        for(int i = 0; i < L1; i++){
            for(int j = 0; j < L2; j++){
                if(nums1[i] + nums2[j] < left){
                    ans.add(Arrays.asList(nums1[i], nums2[j]));
                }else if(nums1[i] + nums2[j] == left){
                    equal.add(Arrays.asList(nums1[i], nums2[j]));
                }
            }
        }
        
        int remainder = k - ans.size();
        for(int i = 0; i < remainder; i++){
            ans.add(equal.get(i));
        }
        
        return ans;
    }
    
    private int countLessEqual(int[] nums1, int[] nums2, int target){
        int ans = 0, i = nums1.length - 1, j = 0;
        while(i >= 0 && j < nums2.length){
            if(nums1[i] + nums2[j] <= target){
                ans += i + 1;
                j++;
            }else{
                i--;
            }
        }
        
        return ans;
    }
}