/**
 * https://leetcode.com/problems/optimal-account-balancing/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/optimal-account-balancing/discuss/95355/Concise-9ms-DFS-solution-(detailed-explanation)/142043
 *  https://leetcode.com/problems/optimal-account-balancing/discuss/95355/Concise-9ms-DFS-solution-(detailed-explanation)
 */
package com.zea7ot.leetcode.lvl5.lc0465;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0Backtrack {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> personToDebt = new HashMap<>();
        for (int[] transaction : transactions) {
            int x = transaction[0], y = transaction[1], z = transaction[2];
            personToDebt.put(x, personToDebt.getOrDefault(x, 0) - z);
            personToDebt.put(y, personToDebt.getOrDefault(y, 0) + z);
        }

        return backtrack(0, new ArrayList<>(personToDebt.values()));
    }

    private int backtrack(int idx, List<Integer> personToDebt) {
        final int SIZE = personToDebt.size();
        while (idx < SIZE && personToDebt.get(idx) == 0) {
            ++idx;
        }

        if (idx == SIZE)
            return 0;

        int res = Integer.MAX_VALUE;
        for (int i = idx + 1; i < SIZE; ++i) {
            if (personToDebt.get(idx) * personToDebt.get(i) < 0) {
                personToDebt.set(i, personToDebt.get(i) + personToDebt.get(idx));
                res = Math.min(res, 1 + backtrack(idx + 1, personToDebt));
                personToDebt.set(i, personToDebt.get(i) - personToDebt.get(idx));
            }
        }

        return res;
    }
}