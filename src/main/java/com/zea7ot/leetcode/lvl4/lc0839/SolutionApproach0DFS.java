/**
 * https://leetcode.com/problems/similar-string-groups/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/similar-string-groups/discuss/132318/Simple-Java-Solution-using-DFS/139892
 */
package com.zea7ot.leetcode.lvl4.lc0839;

public class SolutionApproach0DFS {
    public int numSimilarGroups(String[] arr) {
        // sanity check
        if (arr == null || arr.length == 0)
            return 0;
        final int N = arr.length;

        int ans = 0;
        for (int i = 0; i < N; ++i)
            if (arr[i] != null) {
                ++ans;
                dfs(i, arr);
            }

        return ans;
    }

    private void dfs(int j, String[] arr) {
        final int N = arr.length;
        String str = arr[j];
        arr[j] = null;
        for (int i = 0; i < N; ++i)
            if (arr[i] != null && isSimilar(arr[i], str))
                dfs(i, arr);
    }

    private boolean isSimilar(String source, String target) {
        final int LEN_S = source.length();
        final char[] CHS_S = source.toCharArray();
        final char[] CHS_T = target.toCharArray();
        int diff = 0, idx = 0;
        while (idx < LEN_S && diff <= 2) {
            if (CHS_S[idx] != CHS_T[idx])
                ++diff;

            ++idx;
        }

        return diff == 0 || diff == 2;
    }
}