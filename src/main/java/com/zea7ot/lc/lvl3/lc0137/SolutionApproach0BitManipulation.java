/**
 * https://leetcode.com/problems/single-number-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 */
package com.zea7ot.lc.lvl3.lc0137;

public class SolutionApproach0BitManipulation {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        
        for(int num : nums){
            // first appearence: 
            // add num to seen_once 
            // don't add to seen_twice because of presence in seen_once
            
            // second appearance: 
            // remove num from seen_once 
            // add num to seen_twice
            
            // third appearance: 
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        
        return seenOnce;
    }
}