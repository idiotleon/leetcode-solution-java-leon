/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * 
 * Time Complexity: O(k * lg(k))
 * Space Complexity: O(k)
 * 
 * References:
 *  https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
 *  https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation/150163
 */
package com.idiotleon.leetcode.lvl4.lc0373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionApproach0MinHeap {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // sanity check
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return ans;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for(int i = 0; i < nums1.length && i < k; i++){
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k-- > 0 && !minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            ans.add(Arrays.asList(cur[0], cur[1]));
            if(cur[2] == nums2.length - 1) continue; // reaches the end of nums2
            minHeap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        
        return ans;
    }
}