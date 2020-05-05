/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
package com.polyg7ot.lc.lvl2.lc0658;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionApproachBinarySearch {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return Arrays.stream(arr, left,  right + k).boxed().collect(Collectors.toList());
    }
}