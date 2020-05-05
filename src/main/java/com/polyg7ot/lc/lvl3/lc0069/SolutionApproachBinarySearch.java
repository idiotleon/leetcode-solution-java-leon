/**
 * https://leetcode.com/problems/sqrtx/
 */
package com.polyg7ot.lc.lvl3.lc0069;

public class SolutionApproachBinarySearch {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int start = 1, end = x;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            else if(mid > x / mid) end = mid;
            else start = mid + 1;
        }
        
        return start;
    }
}