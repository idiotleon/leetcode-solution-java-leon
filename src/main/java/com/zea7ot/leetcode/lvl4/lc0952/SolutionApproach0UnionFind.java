/**
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 * 
 * Time Complexity:     O(N * sqrt(largest value of `nums[i]`))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/largest-component-size-by-common-factor/discuss/200959/Simplest-Solution-(Union-Find-only)-No-Prime-Calculation/277687
 *  https://leetcode.com/problems/largest-component-size-by-common-factor/discuss/200959/Simplest-Solution-(Union-Find-only)-No-Prime-Calculation
 */
package com.zea7ot.leetcode.lvl4.lc0952;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0UnionFind {
    public int largestComponentSize(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        final int N = nums.length;
        UnionFind uf = new UnionFind(N);
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            final int NUM = nums[i];
            for (int j = 2; j * j <= NUM; ++j) {
                if (NUM % j != 0)
                    continue;
                union(j, i, valToIdx, uf);
                union(NUM / j, i, valToIdx, uf);
            }

            union(NUM, i, valToIdx, uf);
        }

        return uf.largest;
    }

    private void union(int val, int idx, Map<Integer, Integer> valToIdx, UnionFind uf) {
        valToIdx.putIfAbsent(val, idx);
        uf.union(idx, valToIdx.get(val));
    }

    private class UnionFind {
        private final int[] ROOTS;
        private final int[] SIZES;
        private int largest;

        private UnionFind(final int N) {
            this.ROOTS = new int[N];
            for (int i = 0; i < N; ++i)
                ROOTS[i] = i;
            this.SIZES = new int[N];
            Arrays.fill(SIZES, 1);

            largest = 1;
        }

        private int find(int x) {
            while (x != ROOTS[x]) {
                ROOTS[x] = ROOTS[ROOTS[x]];
                x = ROOTS[x];
            }

            return x;
        }

        private void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX == rootY)
                return;

            if (SIZES[rootX] < SIZES[rootY]) {
                ROOTS[rootX] = rootY;
                SIZES[rootY] += SIZES[rootX];
                largest = Math.max(largest, SIZES[rootY]);
            } else {
                ROOTS[rootY] = rootX;
                SIZES[rootX] += SIZES[rootY];
                largest = Math.max(largest, SIZES[rootX]);
            }
        }
    }
}