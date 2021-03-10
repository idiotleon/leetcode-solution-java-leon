/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O(M * N)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/317092/java-Memoization-solution
 */
package com.an7one.leetcode.lvl4.lc1092;

public class SolutionApproach1DFSMemo {
    public String shortestCommonSupersequence(String str1, String str2) {
        final int L1 = str1.length(), L2 = str2.length();
        String[][] memo = new String[L1][L2];
        final char[] CHS1 = str1.toCharArray(), CHS2 = str2.toCharArray();

        final char[] CHS = dfs(0, CHS1, 0, CHS2, memo).toCharArray();
        final int L = CHS.length;
        if (L == 0)
            return str1 + str2;

        StringBuilder builder = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        for (final char CH : CHS) {
            while (idx1 < L1 && CHS1[idx1] != CH) {
                builder.append(CHS1[idx1++]);
            }

            while (idx2 < L2 && CHS2[idx2] != CH) {
                builder.append(CHS2[idx2++]);
            }

            builder.append(CH);
            ++idx1;
            ++idx2;
        }

        builder.append(str1.substring(idx1));
        builder.append(str2.substring(idx2));

        return builder.toString();
    }

    private String dfs(int idx1, final char[] CHS1, int idx2, final char[] CHS2, String[][] memo) {
        final int L1 = CHS1.length, L2 = CHS2.length;
        if (idx1 >= L1 || idx2 >= L2)
            return "";

        if (memo[idx1][idx2] != null)
            return memo[idx1][idx2];

        if (CHS1[idx1] == CHS2[idx2]) {
            memo[idx1][idx2] = CHS1[idx1] + dfs(idx1 + 1, CHS1, idx2 + 1, CHS2, memo);
        } else {
            String left = dfs(idx1 + 1, CHS1, idx2, CHS2, memo);
            String right = dfs(idx1, CHS1, idx2 + 1, CHS2, memo);

            memo[idx1][idx2] = (left.length() > right.length()) ? left : right;
        }

        return memo[idx1][idx2];
    }
}