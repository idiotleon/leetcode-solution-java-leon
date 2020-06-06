/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity: O(2 * N) ~ O(N)
 * Space Complexity: O(N)
 * 
 *  "Each time all elements to the left are smaller than, 
 *  or equal to, all elements to the right,
 *  there is a new chunk."
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/113462/Java-solution-left-max-and-right-min./182522
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113520/Java-solution-left-max-and-right-min.
 * 
 * Similar Questions:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *  https://leetcode.com/problems/jump-game/
 *  https://leetcode.com/problems/product-of-array-except-self/
 */
package com.zea7ot.lc.lvl4.lc0769;

public class SolutionApproach0FewPasses {
    public int maxChunksToSorted(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        final int N = nums.length;
        int[] minOfRight = new int[N];
        minOfRight[N - 1] = nums[N - 1];
        for(int i = N - 2; i >= 0; i--){
            minOfRight[i] = Math.min(minOfRight[i + 1], nums[i]);
        }
        
        int ans = 0, maxToLeft = Integer.MIN_VALUE;
        for(int i = 0; i < N - 1; i++){
            maxToLeft = Math.max(maxToLeft, nums[i]);
            if(maxToLeft <= minOfRight[i + 1]) ans++;
        }
        
        return ans + 1;
    }
}