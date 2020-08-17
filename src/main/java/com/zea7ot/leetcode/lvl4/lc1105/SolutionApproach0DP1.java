/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution/388498
 */
package com.zea7ot.leetcode.lvl4.lc1105;

public class SolutionApproach0DP1 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int N = books.length;
        
        int[] dp = new int[N + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= N; ++i){
            int curHeight = books[i - 1][1];
            int curWidth = books[i - 1][0];
            // to build a new level for `books[i - 1]`
            dp[i] = dp[i - 1] + curHeight;
            
            // to check whether to put previous books with `books[i - `]` could optimize the situation 
            for(int j = i - 1; j > 0; --j){
                curWidth += books[j - 1][0];
                // to make sure curWidth does not exceed limit
                if(curWidth > shelfWidth) break;
                curHeight = Math.max(curHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + curHeight);
            }
        }
        
        return dp[N];
    }
}