/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
package com.polyg7ot.lc.lvl2.lc0973;

import java.util.Arrays;

public class SolutionApproachQuickSelect {
    public int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length - 1;
        while(left < right){
            int mid = partition(points, left, right);
            if(mid == K) break;
            if(mid < K){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][] nums, int left, int right){
        int[] pivot = nums[left];
        while(left < right){
            while(left < right && compare(nums[right], pivot) >= 0) right--;
            nums[left] = nums[right];
            while(left < right && compare(nums[left], pivot) <= 0) left++;
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
    
    private int compare(int[] p1, int[] p2){
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}