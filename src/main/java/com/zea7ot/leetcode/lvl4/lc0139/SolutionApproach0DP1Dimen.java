/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L ^ 2) + O(N) ~ O(L ^ 2)
 * Space Complexity:    O(L)
 * 
 * `dp[i]` represents whether s[0...i] can be formed by words in the `wordDict`
 * 
 * why "if(j == 0 || dp[j - 1])"?
 * https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution/
 * 251191 The for loop is looking at ranges or substrings. If we know that the
 * current substring is in the dictionary AND the substring before it is also in
 * the dictionary then we know that the str.substring(0, i) is true. j == 0
 * ecause the first substring has nothing before it (dp[j- 1] does not exist).
 * ------- left substring ---- | substring (j, i + 1) | -------right substring
 * ------ | If we know that str.substring(j,i+1) is in the dictionary, we can
 * only mark it true if the left substring is also in the dictionary.
 * 
 * Then, for the right substring, it is str.substring(i + 1, end). You can only
 * mark dp[end] is true if you know the substring up to i are in dictionary.
 * This is what makes this a dynamic programming solution.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution
 */
package com.zea7ot.leetcode.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DP1Dimen {
    public boolean wordBreak(String str, List<String> wordDict) {
        // sanity check
        if (str == null || str.isEmpty())
            return false;

        final int L = str.length();
        final Set<String> WORD_SET = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[L];

        for (int hi = 0; hi < L; ++hi)
            for (int lo = 0; lo <= hi; ++lo)
                /*
                 * why "if(j == 0 || dp[j - 1])"?
                 * https://leetcode.com/problems/word-break/discuss/44054/Java-DP-solution/
                 * 251191 The for loop is looking at ranges or substrings. If we know that the
                 * current substring is in the dictionary AND the substring before it is also in
                 * the dictionary then we know that the str.substring(0, i) is true. j == 0
                 * because the first substring has nothing before it (dp[j- 1] does not exist).
                 * ------- left substring ---- | substring (j, i + 1) | -------right substring
                 * ------ | If we know that str.substring(j,i+1) is in the dictionary, we can
                 * only mark it true if the left substring is also in the dictionary.
                 * 
                 * Then, for the right substring, it is str.substring(i + 1, end). You can only
                 * mark dp[end] is true if you know the substring up to i are in dictionary.
                 * This is what makes this a dynamic programming solution.
                 */
                if (lo == 0 || dp[lo - 1]) {
                    String sub = str.substring(lo, hi + 1);
                    if (WORD_SET.contains(sub))
                        dp[hi] = true;
                }

        return dp[L - 1];
    }
}