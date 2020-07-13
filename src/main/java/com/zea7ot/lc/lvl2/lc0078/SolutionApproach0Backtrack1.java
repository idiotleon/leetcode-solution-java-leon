/**
 * https://leetcode.com/problems/subsets/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation/26405
 *  https://www.mathsisfun.com/sets/power-set.html
 *  https://leetcode.com/problems/subsets/discuss/27288/My-solution-using-bit-manipulation
 */
package com.zea7ot.lc.lvl2.lc0078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums == null || nums.length == 0) return ans;
        
        final int N = nums.length;
        // not necessary
        // Arrays.sort(nums);
        final int TOTAL_NUM = 1 << N;
        for(int i = 0; i < TOTAL_NUM; i++){
            List<Integer> intermediate = new LinkedList<Integer>();
            for(int j = 0; j < N; j++){
                if((i & (1 << j)) != 0){
                    intermediate.add(nums[j]);
                }
            }
            ans.add(intermediate);
        }
        
        return ans;
    }
}