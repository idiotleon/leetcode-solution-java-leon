/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * for(int i = 1; i <= N; ++i){
 *      // i is the last book of the previous levl
 *      for(j = i - 1; j >= 1; --j){
 *          if(totalWidth[j + 1: i] <= W){
 *              dp[i] = min(dp[i], dp[j] + maxHeights[j + 1 : i]);
 *          }else{
 *              break;
 *          }
 *      }
 * }
 * 
 * References:
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution/388498
 *  https://youtu.be/FLbqgyJ-70I?t=3249
 */
package com.an7one.leetcode.lvl4.lc1105;

public class SolutionApproach0DP1Dimen1 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int N = books.length;

        int[] dp = new int[N + 1];
        dp[0] = 0;

        for (int i = 1; i <= N; ++i) {
            int curWidth = books[i - 1][0];
            int curHeight = books[i - 1][1];
            // to build a new level for `books[i - 1]`
            dp[i] = dp[i - 1] + curHeight;

            // to check whether to put previous books with `books[i - `]` could optimize the
            // situation
            for (int j = i - 1; j > 0; --j) {
                curWidth += books[j - 1][0];
                // to make sure curWidth does not exceed limit
                if (curWidth > shelfWidth)
                    break;
                curHeight = Math.max(curHeight, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + curHeight);
            }
        }

        return dp[N];
    }
}