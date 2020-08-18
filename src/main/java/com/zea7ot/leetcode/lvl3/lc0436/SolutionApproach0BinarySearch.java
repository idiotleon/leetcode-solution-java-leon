/**
 * https://leetcode.com/problems/find-right-interval/
 * 
 * Time Complexity: O(N * lg(N))
 * Space Complexity: O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-right-interval/discuss/91793/Java-Concise-Binary-Search/96331
 *  https://leetcode.com/problems/find-right-interval/discuss/91793/Java-Concise-Binary-Search
 */
package com.zea7ot.leetcode.lvl3.lc0436;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0BinarySearch {
    public int[] findRightInterval(int[][] intervals) {
        if(intervals == null || intervals.length < 1) return new int[0];
        
        final int L = intervals.length;
        int[] ans = new int[L];
        
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < L; i++){
            idxMap.put(intervals[i][0], i);
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int i = 0; i < L; i++){
            ans[idxMap.get(intervals[i][0])] = -1;
            
            int left = i + 1, right = L - 1;
            
            while(left < right){
                int mid = left + (right - left) / 2;
                if(intervals[mid][0] < intervals[i][1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            
            if(left < L && intervals[left][0] >= intervals[i][1]){
                ans[idxMap.get(intervals[i][0])] = idxMap.get(intervals[left][0]);
            }
        }
        
        return ans;
    }
}