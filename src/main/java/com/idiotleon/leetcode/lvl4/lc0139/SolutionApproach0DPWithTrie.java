/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(L) + O(N * L)
 * Space Complexity:    O(L) + O(N * L)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43879/Beat-90-JavaC%2B%2B-Trie-DP-Solution-36-lines-7ms3msJava-Set-DP-solution-31-lines-7ms)
 */
package com.idiotleon.leetcode.lvl4.lc0139;

import java.util.List;

public class SolutionApproach0DPWithTrie {
    public boolean wordBreak(String s, List<String> wordDict) {
        // sanity check
        if (s == null || s.isEmpty())
            return false;

        final int L = s.length();
        char[] chs = s.toCharArray();
        TrieNode root = buildTrie(wordDict);

        boolean[] dp = new boolean[L + 1];
        dp[0] = true;
        for (int i = 0; i < L; ++i) {
            if (!dp[i])
                continue;

            int j = i;
            TrieNode cur = root;
            while (j < L && cur.children[chs[j] - 'a'] != null) {
                cur = cur.children[chs[j++] - 'a'];
                if (cur.isWord)
                    dp[j] = true;
            }
        }

        return dp[L];
    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for (String word : wordDict) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    cur.children[idx] = new TrieNode();

                cur = cur.children[idx];
            }

            cur.isWord = true;
        }

        return root;
    }

    private class TrieNode {
        protected boolean isWord;
        protected TrieNode[] children;

        protected TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
}