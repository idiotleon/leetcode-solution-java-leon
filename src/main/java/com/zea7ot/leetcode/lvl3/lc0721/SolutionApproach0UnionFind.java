/**
 * https://leetcode.com/problems/accounts-merge/
 * 
 * Time Complexity:     O(N) ~ O(N * lg(N)) ~ O(N ^ 2)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/286437
 */
package com.zea7ot.leetcode.lvl3.lc0721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0UnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanityc check
        if (accounts == null || accounts.size() == 0)
            return ans;

        // to initialize the union find
        final int N = accounts.size();
        UnionFind uf = new UnionFind(N);

        // to build up the union find
        Map<String, Integer> mailToIndex = new HashMap<String, Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String curMail = accounts.get(i).get(j);
                if (mailToIndex.containsKey(curMail)) {
                    int preIdx = mailToIndex.get(curMail);
                    uf.union(preIdx, i);
                } else {
                    mailToIndex.put(curMail, i);
                }
            }
        }

        Map<Integer, Set<String>> disjointSet = new HashMap<Integer, Set<String>>();
        for (int i = 0; i < N; i++) {
            int parentIndex = uf.find(i);
            disjointSet.putIfAbsent(parentIndex, new HashSet<String>());

            Set<String> curSet = disjointSet.get(parentIndex);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                curSet.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIndex, curSet);
        }

        for (int index : disjointSet.keySet()) {
            List<String> curList = new ArrayList<String>();
            curList.addAll(disjointSet.get(index));

            Collections.sort(curList);
            curList.add(0, accounts.get(index).get(0));
            ans.add(curList);
        }

        return ans;
    }

    private class UnionFind {
        private int[] roots;
        private int[] ranks;

        public UnionFind(int size) {
            this.roots = new int[size];
            this.ranks = new int[size];

            for (int i = 0; i < size; i++) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
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

        public int find(int x) {
            // path compression
            if (x != roots[x]) {
                roots[x] = find(roots[x]);
            }

            return roots[x];
        }
    }
}