/**
 * https://leetcode.com/problems/couples-holding-hands/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC%2B%2B-O(N)-solution-using-cyclic-swapping
 * 
 * Similar Problems:
 *  2   0268    https://leetcode.com/problems/first-missing-positive/
 *  4   0041    https://leetcode.com/problems/first-missing-positive/
 */
package com.zea7ot.leetcode.lvl4.lc0765;

public class SolutionApproach0CyclicSwapping1 {
    public int minSwapsCouples(int[] row) {
        final int N = row.length;
        int ans = 0;
        
        int[] partners = new int[N];
        int[] pos = new int[N];
        
        for(int i = 0; i < N; i++){
            partners[i] = (i % 2 == 0) ? i + 1 : i - 1;
            pos[row[i]] = i;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = partners[pos[partners[row[i]]]]; i != j; j = partners[pos[partners[row[i]]]]){
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                
                ans++;
            }
        }
        
        return ans;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}