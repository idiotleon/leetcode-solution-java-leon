/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Time complexity :
 * Average Case: O(nlogn).
 * Worst Case: O(n^2)O(n). If the numbers in the array are sorted, we don't gain the advantage of divide and conquer.
 * Space complexity : O(n)O(n). Recursion with worst case depth nn.
 */
package com.null7ptr.lc.lvl4.lc0084;

public class SolutionApproachDivideAndConquer {
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
    
    private int calculateArea(int[] heights, int start, int end){
        if(start > end) return 0;
        
        int minIndex = start;
        for(int i = start; i <= end; i++){
            if(heights[i] < heights[minIndex]){
                minIndex = i;
            }
        }
        
        return Math.max(heights[minIndex] * (end - start + 1),
                       Math.max(calculateArea(heights, start, minIndex - 1), calculateArea(heights, minIndex + 1, end)));
    }
}