/**
 * https://leetcode.com/problems/divide-chocolate/
 * 
 * Time Complexity: O(N * lg(totalSum - min))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/divide-chocolate/discuss/408448/Similar-to-problem-no-:-1101-and-410/497005
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/469033
 * 
 * Similar Problems:
 *  https://leetcode.com/problems/split-array-largest-sum/
 *  https://leetcode.com/problems/split-array-largest-sum/
 */
package com.zea7ot.leetcode.lvl4.lc1231;

public class SolutionApproach0BinarySearch {
    public int maximizeSweetness(int[] sweetness, int K) {        
        int left = 0, right = 0; 
        int sum = 0;
        for(int num : sweetness){
            left = Math.min(left, num);
            sum += num;
        }
        right = sum;
        
        // K cuts leads to (K + 1) pieces
        K++;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            int p = getPieces(sweetness, mid);
            
            if(K > p) right = mid - 1;
            else left = mid + 1;
        }
        
        return right;
    }
    
    private int getPieces(int[] sweetness, int K){
        int cuts = 0, sum = 0;
        for(int num : sweetness){
            sum += num;
            if(sum >= K){
                sum = 0;
                cuts++;
            }
        }
        
        return cuts;
    }
}