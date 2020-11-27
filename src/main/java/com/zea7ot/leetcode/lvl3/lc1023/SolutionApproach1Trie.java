/**
 * https://leetcode.com/problems/camelcase-matching/
 * 
 * Time Complexity: O(N * L) + O(N * L) ~ O(N * L)
 *  O(N * L), the Trie
 *  O(N * L), the DFS of the Trie
 * Space Complexity: O(N * L) + O(L) ~  O(N * L)
 *  O(N * L), the Trie
 *  O(L), the call stack
 * 
 * References:
 *  https://leetcode.com/problems/camelcase-matching/discuss/270002/Python-Trie-Solution/324649
 */
package com.zea7ot.leetcode.lvl3.lc1023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach1Trie {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // to build the trie
        TrieNode root = buildTrie(queries);

        Map<String, Boolean> table = new HashMap<String, Boolean>();
        dfs(root, pattern, 0, new StringBuilder(), table);

        // to get the result
        List<Boolean> ans = new ArrayList<Boolean>();
        for (String query : queries) {
            ans.add(table.getOrDefault(query, false));
        }
        return ans;
    }

    private void dfs(TrieNode node, String pattern, int idx, StringBuilder builder, Map<String, Boolean> table) {
        if (idx >= pattern.length()) {
            if (node.isEnd)
                table.put(builder.toString(), true);
            for (char ch : node.children.keySet()) {
                if (ch >= 'a' && ch <= 'z') {
                    dfs(node.children.get(ch), pattern, idx, builder.append(ch), table);
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        } else {
            for (char ch : node.children.keySet()) {
                if (ch == pattern.charAt(idx)) {
                    dfs(node.children.get(ch), pattern, idx + 1, builder.append(ch), table);
                    builder.deleteCharAt(builder.length() - 1);
                } else if (ch >= 'a' && ch <= 'z') {
                    dfs(node.children.get(ch), pattern, idx, builder.append(ch), table);
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
    }

    private TrieNode buildTrie(String[] queries) {
        TrieNode root = new TrieNode();

        for (String query : queries) {
            TrieNode node = root;
            for (char ch : query.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }

                node = node.children.get(ch);
            }

            node.isEnd = true;
        }

        return root;
    }

    private class TrieNode {
        protected Map<Character, TrieNode> children;
        protected boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<Character, TrieNode>();
        }
    }
}