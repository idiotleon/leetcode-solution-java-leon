/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * 
 * Time Complexity:     O((N ^ 2) * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197693/Java-Union-Find
 */
package com.zea7ot.leetcode.lvl4.lc0947;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0UnionFind1 {

    private int count = 0;

    public int removeStones(int[][] stones) {
        // sanity check
        if (stones == null || stones.length == 0)
            return 0;

        Map<String, String> roots = new HashMap<>();
        this.count = stones.length;

        // to initialize UnionFind
        for (int[] stone : stones) {
            String str = stone[0] + "," + stone[1];
            roots.put(str, str);
        }

        for (int[] stone1 : stones) {
            String str1 = stone1[0] + "," + stone1[1];
            for (int[] stone2 : stones) {
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    String str2 = stone2[0] + "," + stone2[1];
                    union(roots, str1, str2);
                }
            }
        }

        return stones.length - count;
    }

    private void union(Map<String, String> roots, String stone1, String stone2) {
        String root1 = find(roots, stone1), root2 = find(roots, stone2);
        if (root1.equals(root2))
            return;

        roots.put(root2, root1);
        count--;
    }

    private String find(Map<String, String> roots, String stone) {
        if (!roots.get(stone).equals(stone)) {
            roots.put(stone, find(roots, roots.get(stone)));
        }

        return roots.get(stone);
    }
}