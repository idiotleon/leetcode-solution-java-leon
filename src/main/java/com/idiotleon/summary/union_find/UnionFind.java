package com.idiotleon.summary.union_find;

import com.idiotleon.util.Constant;

/**
 * @author: Leon
 * <p>
 * Time Complexities:
 * Find:
 * with optimization:      O(a(N)) ~ O(1)
 * without optimization:   O(N)
 * Union:  O(a(N)) ~ O(1)
 * <p>
 * Space Complexity: O(N)
 * <p>
 * Optimizations:
 * 1. path compression
 * 2. union by rank
 * <p>
 * References:
 * <a href="https://www.youtube.com/watch?v=VJnUwsE4fWA">reference</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class UnionFind {
    private final int[] roots;
    private final int[] ranks;

    public UnionFind(final int N) {
        this.roots = new int[N];
        // attention: do NOT forget to initialize roots
        for (int i = 0; i < N; ++i) {
            this.roots[i] = i;
        }
        // ranks(int[]) can be left with default initialization of an integer array
        this.ranks = new int[N];
    }

    public int find(int x) {
        if (x != roots[x]) {
            // path compression
            roots[x] = find(roots[x]);
        }
        return roots[x];
    }

    public int find2(int x) {
        if (roots[x] == x) return x;
        // path compression
        return roots[x] = find(roots[x]);
    }

    public int find3(int x) {
        while (x != roots[x]) {
            roots[x] = roots[roots[x]];
            x = roots[x];
        }
        return x;
    }

    // union by rank
    public void union(int x, int y) {
        int parentX = find(x), parentY = find(y);
        if (ranks[parentX] > ranks[parentY]) roots[parentY] = parentX;
        else if (ranks[parentY] < ranks[parentX]) roots[parentX] = parentY;
        else {
            roots[parentY] = parentX;
            ranks[parentX]++;
        }
    }
}