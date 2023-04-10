/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Time Complexity:     O(L1 * L2)
 * Space Complexity:    O(L1 * L2)
 * 
 * References:
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/398711/ALL-4-ways-Recursion-greater-Top-down-greaterBottom-Up-greater-Efficient-Solution-O(N)-including-VIDEO-TUTORIAL
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/841563/Java-Recursion-greater-memo-greater-dp
 */
package com.idiotleon.leetcode.lvl3.lc1143;

public class SolutionApproach0DFSMemo {
    public int longestCommonSubsequence(String text1, String text2) {
        final int L1 = text1.length(), L2 = text2.length();
        final char[] CHS1 = text1.toCharArray(), CHS2 = text2.toCharArray();
        Integer[][] memo = new Integer[L1][L2];
        return dfs(0, CHS1, 0, CHS2, memo);
    }

    private int dfs(int idx1, final char[] CHS1, int idx2, final char[] CHS2, Integer[][] memo) {
        final int L1 = CHS1.length, L2 = CHS2.length;
        if (idx1 >= L1 || idx2 >= L2)
            return 0;
        if (memo[idx1][idx2] != null)
            return memo[idx1][idx2];

        int longest = 0;
        if (CHS1[idx1] == CHS2[idx2]) {
            longest = dfs(idx1 + 1, CHS1, idx2 + 1, CHS2, memo) + 1;
        } else {
            longest = Math.max(dfs(idx1 + 1, CHS1, idx2, CHS2, memo), dfs(idx1, CHS1, idx2 + 1, CHS2, memo));
        }

        return memo[idx1][idx2] = longest;
    }
}
