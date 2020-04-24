/**
 * https://leetcode.com/problems/single-number-ii/
 */
package main.java.lcidiot.lc.lvl3.lc0137;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproachHashSet {
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<Long>();
        long sumSet = 0, sumArray = 0;
        for(int num : nums){
            sumArray += num;
            set.add((long)num);
        }
        
        for(Long s : set) sumSet += s;
        return (int)((3 * sumSet - sumArray) / 2);
    }
}