package com.idiotleon.leetcode.lvl3.lc0721;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/accounts-merge/">LC0721</a>
 * <p>
 * Time Complexity:     O(N) ~ O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O()
 * <p>
 * Reference:
 * <a href="https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144">reference</a>
 * <a href="https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/286437">reference</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0UnionFind {
    public List<List<String>> accountsMerge(final List<List<String>> accounts) {
        final List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (accounts == null || accounts.size() == 0) {
            return ans;
        }

        // to initialize the union find
        final int N = accounts.size();
        final UnionFind uf = new UnionFind(N);

        // to build up the union find
        final Map<String, Integer> mailToIndex = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                final String curMail = accounts.get(i).get(j);
                if (mailToIndex.containsKey(curMail)) {
                    int preIdx = mailToIndex.get(curMail);
                    uf.union(preIdx, i);
                } else {
                    mailToIndex.put(curMail, i);
                }
            }
        }

        final Map<Integer, Set<String>> disjointSet = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            final int parentIndex = uf.find(i);
            disjointSet.putIfAbsent(parentIndex, new HashSet<>());

            final Set<String> curSet = disjointSet.get(parentIndex);
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                curSet.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIndex, curSet);
        }

        for (int index : disjointSet.keySet()) {
            final List<String> curList = new ArrayList<>(disjointSet.get(index));
            Collections.sort(curList);
            curList.add(0, accounts.get(index).get(0));
            ans.add(curList);
        }

        return ans;
    }

    private static class UnionFind {
        private final int[] roots;
        private final int[] ranks;

        public UnionFind(final int size) {
            this.roots = new int[size];
            this.ranks = new int[size];

            for (int i = 0; i < size; ++i) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        public void union(final int x, final int y) {
            final int rootX = find(x);
            final int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
                ++ranks[rootX];
            } else {
                roots[rootX] = rootY;
                ++ranks[rootY];
            }
        }

        public int find(final int x) {
            // path compression
            if (x != roots[x]) {
                roots[x] = find(roots[x]);
            }

            return roots[x];
        }
    }
}