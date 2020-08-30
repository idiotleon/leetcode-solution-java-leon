/**
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/the-skyline-problem/discuss/61313/A-segment-tree-solution/185639
 *  https://www.youtube.com/watch?v=ZBHKZF5w4YU&list=PLXjkndB54dnJ9Ml7J7M85TB_pyvcVVuGi&index=2
 *  https://www.youtube.com/watch?v=xuoQdt5pHj0&list=PLXjkndB54dnJ9Ml7J7M85TB_pyvcVVuGi&index=3
 */
package com.zea7ot.leetcode.lvl4.lc0218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SolutionApproach0SegmentedTree {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Set<Integer> set = new TreeSet<>();
        for (int[] building : buildings) {
            set.add(building[0]);
            set.add(building[1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> rMap = new HashMap<>();
        int k = 0;
        for (int iter : set) {
            map.put(iter, k);
            rMap.put(k++, iter);
        }

        SegmentedTree segTree = new SegmentedTree(k << 4);

        // to turn `k` into 0-indexed
        --k;
        for (int[] building : buildings)
            segTree.update(1, map.get(building[0]), map.get(building[1]) - 1, building[2], 0, k);

        int prevHeight = 0, curHeight = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= k; ++i) {
            curHeight = segTree.rangeQuery(1, i, 0, k);
            if (prevHeight == curHeight)
                continue;
            ans.add(Arrays.asList(rMap.get(i), curHeight));
            prevHeight = curHeight;
        }

        return ans;
    }

    private class SegmentedTree {
        private int[] segTree;

        private SegmentedTree(final int SIZE) {
            this.segTree = new int[SIZE];
        }

        private void update(int node, int lo, int hi, int val, final int LEFT, final int RIGHT) {
            if (lo > hi || hi < LEFT || hi > RIGHT)
                return;

            // lazy propagation
            if (LEFT == lo && RIGHT == hi) {
                segTree[node] = Math.max(segTree[node], val);
                return;
            }

            final int MID = LEFT + (RIGHT - LEFT) / 2;
            update(node << 1, lo, Math.min(MID, hi), val, LEFT, MID);
            update((node << 1) + 1, Math.max(MID + 1, lo), hi, val, MID + 1, RIGHT);
        }

        private int rangeQuery(int node, int idx, final int LEFT, final int RIGHT) {
            if (LEFT == RIGHT)
                return segTree[node];

            final int MID = LEFT + (RIGHT - LEFT) / 2;
            int res = idx <= MID ? rangeQuery(node << 1, idx, LEFT, MID)
                    : rangeQuery((node << 1) + 1, idx, MID + 1, RIGHT);
            return Math.max(res, segTree[node]);
        }
    }
}