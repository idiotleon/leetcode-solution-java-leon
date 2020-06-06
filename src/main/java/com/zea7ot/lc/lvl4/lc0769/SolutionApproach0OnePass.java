/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 * 
 * Similar Questions:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *  https://leetcode.com/problems/jump-game/
 *  https://leetcode.com/problems/product-of-array-except-self/
 */
package com.zea7ot.lc.lvl4.lc0769;

public class SolutionApproach0OnePass {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        
        final int L = arr.length;
        int count = 0, max = 0;
        for(int i = 0; i < L; i++){
            max = Math.max(max, arr[i]);
            if(max == i){
                count++;
            }
        }
        
        return count;
    }
}