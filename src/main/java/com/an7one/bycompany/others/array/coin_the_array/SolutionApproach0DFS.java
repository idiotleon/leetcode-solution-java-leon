/**
 * Given two arrays: `nums`(1 dimensional), and `pieces`(2 dimensional),
 * can `nums` be coined with components of `pieces`?
 * 
 * e.g. 1: 
 *  nums:       [1,3,5,3]
 *  pieces:     [[1],[3,5],[3]]
 *  expected:   true
 * 
 * e.g. 2: 
 *  nums:       [1,3,5,3]
 *  pieces:     [[1],[5,3],[3]]
 *  expected:   false
 */
package com.an7one.bycompany.others.array.coin_the_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS {
    public boolean canCoinTogether(int[] nums, int[][] pieces) {
        if (nums == null || nums.length == 0)
            return false;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] piece : pieces) {
            int start = piece[0];
            map.putIfAbsent(start, new ArrayList<int[]>());
            map.get(start).add(piece);
        }

        return dfs(0, nums, map);
    }

    private boolean dfs(int idx, int[] nums, Map<Integer, List<int[]>> map) {
        final int N = nums.length;
        if (idx == N)
            return true;

        List<int[]> pieces = map.get(nums[idx]);
        final int SIZE = pieces.size();
        for (int i = 0; i < SIZE; ++i) {
            int[] piece = pieces.get(i);
            final int LEN = piece.length;
            if (isSubarray(idx, nums, piece)) {
                pieces.remove(i);
                if (dfs(idx + LEN, nums, map))
                    return true;
            }
        }

        return false;
    }

    private boolean isSubarray(int idx, int[] nums, int[] piece) {
        final int N_P = piece.length, N = nums.length;
        if (idx + N_P > N)
            return false;
        for (int i = idx; i < N_P; ++i) {
            if (nums[i] != piece[i])
                return false;
        }

        return true;
    }
}