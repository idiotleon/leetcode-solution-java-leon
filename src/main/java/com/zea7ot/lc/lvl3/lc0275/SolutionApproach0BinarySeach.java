/**
 * https://leetcode.com/problems/h-index-ii/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0275;

public class SolutionApproach0BinarySeach {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        final int L = citations.length;
        int left = 0, right = L - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(citations[mid] == L - mid) return L - mid;
            if(citations[mid] < L - mid) left = mid + 1;
            else right = mid - 1;
        }
        
        return L - left;
    }
}