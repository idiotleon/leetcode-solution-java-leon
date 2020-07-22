/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * `dp[i]`, minimum height to place `books[0]` ~ `books[i]`
 * dp[j] = min{dp[i - 1] + H}, 0 < i < j
 *  H = max(height[i ~ j]), given that sum(width[i ~ j]) <= maxWidth
 * ans: dp[N - 1]
 * 
 * References:
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323315/Java-DP-solution/352190
 */
package com.zea7ot.lc.lvl4.lc1105;

public class SolutionApproach0DP {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int N = books.length;
        
        int[] dp = new int[N + 1];
        dp[0] = 0;
        
        for(int i = 1; i <= N; ++i){
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            dp[i] = dp[i - 1] + height;
            
            for(int j = i - 1; j > 0 && width + books[j - 1][0] <= shelfWidth; --j){
                height = Math.max(height, books[j - 1][1]);
                width += books[j - 1][0];
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        
        return dp[N];
    }
}