/**
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/majority-element-ii/discuss/63500/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!
 */
package com.zea7ot.leetcode.lvl3.lc0229;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0BoyerMoorMajorityVoteAlgorithm {
    public List<Integer> majorityElement(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return new ArrayList<Integer>();
        
        List<Integer> ans = new ArrayList<Integer>();
        final int N = nums.length;
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] == num1) ++count1;
            else if(nums[i] == num2) ++count2;
            else if(count1 == 0){
                num1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                num2 = nums[i];
                count2 = 1;
            }else{
                --count1;
                --count2;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] == num1) ++count1;
            else if(nums[i] == num2) ++count2;
        }
        
        if(count1 > N / 3) ans.add(num1);
        if(count2 > N / 3) ans.add(num2);
        return ans;
    }
}