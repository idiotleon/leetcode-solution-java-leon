/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * 
 * Time Complexity: O(N * lg(SIZE))
 *  SIZE is the the actual search space, i.e. (sum of weights - max weight)
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC%2B%2BPython-Binary-Search
 *  https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC++Python-Binary-Search/249951
 *  https://www.topcoder.com/community/competitive-programming/tutorials/binary-search/
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/divide-chocolate/
 *  https://leetcode.com/problems/split-array-largest-sum/
 */
package com.idiotleon.leetcode.lvl4.lc1011;

public class SolutionApproach0BinarySearch {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for(int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        
        // to [binary] search the minimum value,
        // instead of the exact value
        while(left < right){
            int mid = left + (right - left) / 2, need = 1, cur = 0;
            // to get the how many dayes "need"ed, 
            // with current capacity of "mid"
            for(int weight : weights){
                if(cur + weight > mid){
                    need += 1;
                    cur = 0;
                }
                
                cur += weight;
            }
            
            if(need > D) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}