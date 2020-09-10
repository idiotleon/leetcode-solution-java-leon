/**
 * https://leetcode.com/problems/accounts-merge/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * 
 * References:
 *  https://leetcode.com/problems/accounts-merge/discuss/109157/JavaC++-Union-Find/241144
 */
package com.zea7ot.leetcode.lvl4.lc0721;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0UnionFind {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        LinkedList<List<String>> ans = new LinkedList<>();
        // sanity check
        if (accounts == null || accounts.isEmpty())
            return ans;

        final int NR = accounts.size();
        UnionFind uf = new UnionFind(NR);

        Map<String, Integer> emailToIdx = new HashMap<>();
        for (int row = 0; row < NR; ++row) {
            final int NC = accounts.get(row).size();
            for (int col = 1; col < NC; ++col) {
                String curEmail = accounts.get(row).get(col);
                if (emailToIdx.containsKey(curEmail)) {
                    int idx = emailToIdx.get(curEmail);
                    uf.union(idx, row);
                } else {
                    emailToIdx.put(curEmail, row);
                }
            }
        }

        Map<Integer, Set<String>> map = new HashMap<>();
        for (int row = 0; row < NR; ++row) {
            final int IDX_ROOT = uf.find(row);
            map.putIfAbsent(IDX_ROOT, new HashSet<>());
            final Set<String> CUR_SET = map.get(IDX_ROOT);
            final int NC = accounts.get(row).size();
            for (int col = 1; col < NC; ++col)
                CUR_SET.add(accounts.get(row).get(col));

            // map.put(IDX_ROOT, CUR_SET);
        }

        for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
            LinkedList<String> res = new LinkedList<>(entry.getValue());
            Collections.sort(res);
            res.addFirst(accounts.get(entry.getKey()).get(0));
            ans.add(res);
        }

        return ans;
    }

    private class UnionFind {
        private final int[] ROOTS;
        private final int[] RANKS;

        private UnionFind(int size) {
            this.ROOTS = new int[size];
            this.RANKS = new int[size];
            for (int i = 0; i < size; ++i) {
                ROOTS[i] = i;
                RANKS[i] = 1;
            }
        }

        private void union(int x, int y) {
            final int ROOT_X = find(x);
            final int ROOT_Y = find(y);

            if (ROOT_X == ROOT_Y)
                return;
            if (RANKS[ROOT_X] > RANKS[ROOT_Y]) {
                ROOTS[ROOT_Y] = ROOT_X;
                RANKS[ROOT_X] += RANKS[ROOT_Y];
            } else {
                ROOTS[ROOT_X] = ROOT_Y;
                RANKS[ROOT_Y] += RANKS[ROOT_X];
            }
        }

        private int find(int x) {
            if (x != ROOTS[x])
                ROOTS[x] = find(ROOTS[x]);

            return ROOTS[x];
        }
    }
}
