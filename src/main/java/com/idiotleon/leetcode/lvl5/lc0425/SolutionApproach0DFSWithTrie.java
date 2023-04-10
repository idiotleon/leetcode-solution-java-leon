/**
 * https://leetcode.com/problems/word-squares/
 * 
 * Time Complexity: O(N * L) + 
 * Space Complexity: O(N * L) + 
 * 
 * References:
 *  https://leetcode.com/problems/word-squares/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616/95910
 *  https://leetcode.com/problems/word-squares/discuss/91333/Explained.-My-Java-solution-using-Trie-126ms-1616/95925
 */
package com.idiotleon.leetcode.lvl5.lc0425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0DFSWithTrie {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (words == null || words.length == 0)
            return ans;
        final int L = words[0].length();

        TrieNode root = buildTrie(words);
        TrieNode[] roots = new TrieNode[L];
        Arrays.fill(roots, root);

        dfs(roots, new char[L][L], 0, ans);

        return ans;
    }

    private void dfs(TrieNode[] roots, char[][] intermediate, int idx, List<List<String>> ans) {

        if (idx == intermediate.length) {
            List<String> list = new ArrayList<>(idx);
            for (char[] chs : intermediate)
                list.add(new String(chs));
            ans.add(list);
            return;
        }

        TrieNode[] nextRoots = new TrieNode[roots.length];
        for (String candidate : roots[idx].list) {
            char[] chs = candidate.toCharArray();
            int i = idx;
            for (; i < intermediate.length; i++) {
                char ch = chs[i];
                // to save intermediate results in intermediate(char[][])
                intermediate[idx][i] = ch;
                // to update idx-th row and col simultaneously
                if (i > idx) {
                    intermediate[i][idx] = ch;
                    // early pruning if row[0,..,idx] cannot form a prefix
                    if (roots[i].children[ch - 'a'] == null)
                        break;
                    nextRoots[i] = roots[i].children[ch - 'a'];
                }
            }

            if (i == intermediate.length) {
                dfs(nextRoots, intermediate, idx + 1, ans);
            }
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.list.add(word);
            TrieNode node = root;
            for (final char CH : word.toCharArray()) {
                final int IDX = CH - 'a';
                if (node.children[IDX] == null) {
                    node.children[IDX] = new TrieNode();
                }
                node = node.children[IDX];
                node.list.add(word);
            }
        }

        return root;
    }

    private class TrieNode {
        private final List<String> list;
        private final TrieNode[] children;

        private TrieNode() {
            list = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
}
