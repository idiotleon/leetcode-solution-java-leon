/**
 * https://leetcode.com/problems/similar-string-groups/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/similar-string-groups/discuss/132374/Short-C++-solution-at-220ms-using-disjoint-set/164567
 *  https://leetcode.com/problems/similar-string-groups/discuss/132374/Short-C%2B%2B-solution-at-220ms-using-disjoint-set
 */
package com.zea7ot.lc.lvl4.lc0839;

public class SolutionApproach0UnionFind {
    public int numSimilarGroups(String[] arr) {
        final int N = arr.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N - 1; ++i)
            for (int j = i + 1; j < N; ++j) {
                if (isSimilar(arr[i], arr[j]))
                    uf.union(i, j);

                // pruning here
                if (uf.getGroups() == 1)
                    return 1;
            }

        return uf.getGroups();
    }

    private boolean isSimilar(String source, String target) {
        final int LEN_S = source.length();
        int diff = 0;
        for (int i = 0; i < LEN_S; ++i)
            if (source.charAt(i) != target.charAt(i)) {
                // pruning here
                if (++diff == 3)
                    return false;
            }

        return (diff == 2 || diff == 0);
    }

    // another version, which turns out to be slow
    // private boolean isSimilar(String source, String target){
    // final int LEN_S = source.length();
    // final char[] CHS_S = source.toCharArray();
    // final char[] CHS_T = target.toCharArray();
    // int diff = 0;

    // for(int i = 0; i < LEN_S; ++i)
    // if(CHS_S[i] != CHS_T[i]){
    // if(diff == 3) return false;
    // ++diff;
    // }

    // return (diff == 2 || diff == 0);
    // }

    private class UnionFind {
        protected int[] roots, ranks;
        private int groups;

        protected UnionFind(final int N) {
            this.groups = N;
            this.roots = new int[N];
            for (int i = 0; i < N; ++i)
                roots[i] = i;
            this.ranks = new int[N];
        }

        protected void union(int i, int j) {
            int iRoot = find(i), jRoot = find(j);
            if (iRoot == jRoot)
                return;
            if (ranks[iRoot] > ranks[jRoot]) {
                roots[jRoot] = iRoot;
                ++ranks[iRoot];
            } else {
                roots[iRoot] = jRoot;
                ++ranks[jRoot];
            }

            --groups;
        }

        protected int find(int x) {
            if (roots[x] != x)
                roots[x] = find(roots[x]);

            return roots[x];
        }

        // another version of find
        // protected int find1(int x){
        // while(roots[x] != x)
        // return find(roots[x]);

        // return x;
        // }

        protected int getGroups() {
            return groups;
        }
    }
}