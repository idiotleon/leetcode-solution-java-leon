/**
 * https://leetcode.com/problems/reverse-pairs/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
 */
package com.an7one.leetcode.lvl5.lc0493;

public class SolutionApproach0MergeSort {
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }
    
    private int reversePairs(int[] nums, int left, int right){
        if(left >= right) return 0;
        
        int mid = left + (right - left) / 2;
        int ans = reversePairs(nums, left, mid) + reversePairs(nums, mid + 1, right);
        
        int i = left, j = mid + 1, k = 0, p = mid + 1;
        int[] merge = new int[right - left + 1];
        
        while(i <= mid){
            while(p <= right && nums[i] > 2L * nums[p]) p++;
            ans += p - (mid + 1);
            
            while(j <= right && nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }
        
        while(j <= right) merge[k++] = nums[j++];
        
        System.arraycopy(merge, 0, nums, left, merge.length);

        return ans;
    }
}