/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 * 
 * Time Complexity: O(m * lg(m * n - 1))
 * Space Complexity: O(1)
 * 
 * References:
 *  https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/discuss/106977/Java-solution-binary-search
 */
package com.polyg7ot.lc.lvl4.lc0668;

public class SolutionApproach0BinarySearch {
    public int findKthNumber(int m, int n, int k) {
        if(k >= m * n) return m * n;
        int lo = 1, hi = m * n;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int count = getCount(m, n, mid);
            
            if(k > count) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return lo;
    }
    
    private int getCount(int m, int n, int target){
        int count = 0;
        for(int i = 1; i <= m; i++){
            int temp = Math.min(target / i, n);
            count += temp;
        }
        
        return count;
    }
}