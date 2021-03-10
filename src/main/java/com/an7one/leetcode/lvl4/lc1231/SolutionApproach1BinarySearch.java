/**
 * https://leetcode.com/problems/divide-chocolate/
 * 
 * Time Complexity: O(N * lg(10 ^ 9))
 * Space Complexity: O(1)
 */
package com.an7one.leetcode.lvl4.lc1231;

public class SolutionApproach1BinarySearch {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 1, right = (int) 1e9 / (K + 1);
        
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            int cur = 0, cuts = 0;
            for(int num : sweetness){
                if((cur += num) >= mid){
                    cur = 0;
                    if(++cuts > K) break;
                }
            }
            
            if(cuts > K) left = mid;
            else right = mid - 1;
        }
        
        return left;
    }
}