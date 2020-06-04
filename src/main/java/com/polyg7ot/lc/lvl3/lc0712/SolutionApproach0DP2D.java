/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * 
 * Time Complexity:     O(M * N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108828/C%2B%2B-DP-with-explanation
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/161054/Java-O(nm)-time-and-O(n)-space-solution
 */
package com.polyg7ot.lc.lvl3.lc0712;

public class SolutionApproach0DP2D {
    public int minimumDeleteSum(String s1, String s2) {
        final int M = s1.length(), N = s2.length();
        int[] dp = new int[N + 1];
        for(int j = 1; j <= N; j++){
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }
        
        for(int i = 1; i <= M; i++){
            int prev = dp[0];
            dp[0] += s1.charAt(i - 1);
            for(int j = 1; j <= N; j++){
                int cur = dp[j];
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[j] = prev;
                }else{
                    dp[j] = Math.min(dp[j] + s1.charAt(i - 1), dp[j - 1] + s2.charAt(j - 1));
                }
                prev = cur;
            }
        }
        
        return dp[N];
    }
}