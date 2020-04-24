/**
 * https://leetcode.com/problems/largest-number/
 */
package main.java.lcidiot.lc.lvl4.lc0179;

import java.util.Arrays;

public class SolutionApproachSortedArray {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        // to convert int array into String array for sorting later on
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
                    
        if(strs[0].charAt(0) == '0') return "0";
        
        StringBuilder builder = new StringBuilder();
        for(String str : strs) builder.append(str);
        
        return builder.toString();
    }
}