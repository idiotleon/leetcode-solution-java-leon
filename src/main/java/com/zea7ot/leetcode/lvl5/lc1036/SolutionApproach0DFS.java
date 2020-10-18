/**
 * https://leetcode.com/problems/escape-a-large-maze/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282849/Python-BFS-and-DFS-Maximum-Blocked-19900/269098
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282889/My-Java-DFS-Solution-with-Some-Thoughts-(Triangle-v.s.-14-Circle-in-Pixels)/269264
 */
package com.zea7ot.leetcode.lvl5.lc1036;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0DFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private static final int LIMIT = (int) 1e6;

    private static final int MAX_VISITS = (int) 2e4;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        final Set<String> BLOCKS = new HashSet<>();
        for (int[] block : blocked) {
            BLOCKS.add(hash(block[0], block[1]));
        }

        return dfs(source, target, new HashSet<>(), BLOCKS) && dfs(target, source, new HashSet<>(), BLOCKS);
    }

    private boolean dfs(int[] source, int[] target, final Set<String> SEEN, final Set<String> BLOCKED) {
        if (Arrays.equals(source, target) || SEEN.size() >= MAX_VISITS)
            return true;

        for (int d = 0; d < 4; ++d) {
            int nextRow = source[0] + DIRS[d];
            int nextCol = source[1] + DIRS[d + 1];

            String hash = hash(nextRow, nextCol);
            if (nextRow < 0 || nextCol < 0 || nextRow >= LIMIT || nextCol >= LIMIT || BLOCKED.contains(hash)
                    || !SEEN.add(hash))
                continue;

            if (dfs(new int[] { nextRow, nextCol }, target, SEEN, BLOCKED))
                return true;
        }

        return false;
    }

    private String hash(int row, int col) {
        return "" + row + "#" + col;
    }
}
