/**
 * https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/discuss/610701/JavaC%2B%2BPython-Binary-Search-and-Prune-Backtracking-O(m*k*log(m*5000))-~-4ms
 */
package com.an7one.leetcode.lvl4.lc1439;

public class SolutionApproach0Guess {
    public int kthSmallest(int[][] mat, int k) {
        final int NR = mat.length, NC = mat[0].length;
        int lo = NR, hi = NC * 5_000;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = getCounts(mat, mid, 0, 0, k);
            if(k > count){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        
        return lo;
    }
    
    /**
     * to backtrack to get counts
     * 
     * @param mat
     * @param targetSum
     * @param row
     * @param sum
     * @param k
     * @return
     */
    private int getCounts(int[][] mat, int targetSum, int row, int sum, int k){
        final int NR = mat.length, NC = mat[0].length;
        if(sum > targetSum) return 0;
        if(row == NR) return 1;
        int res = 0;
        for(int col = 0; col < NC; col++){
            int count = getCounts(mat, targetSum, row + 1, sum + mat[row][col], k - res);
            if(count == 0) break; // to prune
            res += count;
            if(res > k) break; // to prune when count > k
        }
        
        return res;
    }
}