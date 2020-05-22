/**
 * https://leetcode.com/problems/reverse-pairs/
 * 
 * Not yet:
 *  why (left + 1) is returned in the binary search is yet to be understood
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
 */
package com.polyg7ot.lc.lvl5.lc0493;

import java.util.Arrays;

public class SolutionApproach0BIT {
    public int reversePairs(int[] nums) {
        int ans = 0;
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];
        
        Arrays.sort(copy);
        
        for(int num : nums){
            ans += search(bit, index(copy, 2L * num + 1));
            insert(bit, index(copy, num));
        }
        
        return ans;
    }
    
    private int index(int[] nums, long val){
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(val > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        
        return left + 1;
    }
    
    
//     private int index(int[] arr, long val) {
//     int l = 0, r = arr.length - 1, m = 0;
    	
//     while (l <= r) {
//     	m = l + ((r - l) >> 1);
    		
//     	if (arr[m] >= val) {
//     	    r = m - 1;
//     	} else {
//     	    l = m + 1;
//     	}
//     }
    
//     return l + 1;
// }
    
    private int search(int[] bit, int i){
        int sum = 0;
        
        while(i < bit.length){
            sum += bit[i];
            i += i & -i;
        }
        
        return sum;
    }
    
    private void insert(int[] bit, int i){
        while(i > 0){
            bit[i] += 1;
            i -= i & -i;
        }
    }
}