/**
 * @author: Leon
 * https://leetcode.com/problems/smallest-string-with-swaps/
 * 
 * Time Complexity:     O(L) + O(N)
 * Space Complexity:    O(L) + O(N)
 * 
 * References:
 *  https://leetcode.com/problems/smallest-string-with-swaps/discuss/388055/Java-Union-find-%2B-PriorityQueue.-Easy-to-understand.
 */
package com.zea7ot.leetcode.lvl4.lc1202;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0UnionFind {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        final int L = s.length();
        UnionFind uf = new UnionFind(L);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        final char[] CHS = s.toCharArray();
        for (int i = 0; i < L; ++i) {
            int root = uf.find(i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).offer(CHS[i]);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < L; ++i) {
            builder.append(map.get(uf.find(i)).poll());
        }

        return builder.toString();
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;

        private UnionFind(final int N) {
            this.roots = new int[N];
            this.ranks = new int[N];
            for (int i = 0; i < N; ++i) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        private int find(int x) {
            if (x != roots[x]) {
                roots[x] = find(roots[x]);
            }

            return roots[x];
        }

        private void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY)
                return;
            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
                ++ranks[rootX];
            } else {
                roots[rootX] = rootY;
                ++ranks[rootY];
            }
        }
    }
}
