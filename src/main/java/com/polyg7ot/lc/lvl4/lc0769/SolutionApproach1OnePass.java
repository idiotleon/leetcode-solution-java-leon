/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation
 */
package com.polyg7ot.lc.lvl4.lc0769;

public class SolutionApproach1OnePass {
    public int maxChunksToSorted(int[] arr) {
        // sanity check
        if(arr == null || arr.length == 0) return 0;
        
        final int L = arr.length;
        int[] max = new int[L];
        max[0] = arr[0];
        
        for(int i = 1; i < L; i++){
            max[i] = Math.max(max[i - 1], arr[i]);
        }
        
        int count = 0;
        for(int i = 0; i < L; i++){
            if(max[i] == i){
                count++;
            }
        }
        
        return count;
    }
}