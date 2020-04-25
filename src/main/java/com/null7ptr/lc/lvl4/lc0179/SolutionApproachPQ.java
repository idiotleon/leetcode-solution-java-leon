/**
 * https://leetcode.com/problems/largest-number/
 */
package com.null7ptr.lc.lvl4.lc0179;

import java.util.PriorityQueue;

public class SolutionApproachPQ{
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        if(containsOnlyZeros(nums)) return "0";
        
        PriorityQueue<String> heap = new PriorityQueue<String>((a, b) -> (b + a).compareTo(a + b));
        for(int num : nums) heap.offer(String.valueOf(num));
        
        StringBuilder builder = new StringBuilder();
        while(!heap.isEmpty()){
            builder.append(heap.poll());
        }
        
        return trimZero(builder.toString());
    }
    
    private boolean containsOnlyZeros(int[] nums){
        if(nums == null || nums.length == 0) return false;
        
        for(int num : nums) {
            if(num != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private String trimZero(String str){
        for(char c : str.toCharArray()){
            if(c != '0'){
                return str;
            }
        }
        
        return "0";
    }
}