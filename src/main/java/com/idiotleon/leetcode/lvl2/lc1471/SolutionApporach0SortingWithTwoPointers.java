/**
 * https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/the-k-strongest-values-in-an-array/discuss/674384/C%2B%2BJavaPython-Two-Pointers-%2B-3-Bonuses
 */
package com.idiotleon.leetcode.lvl2.lc1471;

import java.util.Arrays;

public class SolutionApporach0SortingWithTwoPointers {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        final int L = arr.length;
        
        final int median = arr[(L - 1) / 2];
        
        int[] ans = new int[k];
        int idx = 0, i = 0, j = L - 1;
        while(idx < k){
            if(arr[i] - median >= median - arr[j]){
                ans[idx++] = arr[j--];
            }else{
                ans[idx++] = arr[i++];
            }
        }
        
        return ans;
    }
}