/**
 * https://leetcode.com/problems/escape-a-large-maze/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/escape-a-large-maze/discuss/282849/Python-BFS-and-DFS-Maximum-Blocked-19900/269098
 */
package com.zea7ot.leetcode.lvl5.lc1036;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    private static final int[] DIRS = { 0, -1, 0, 1, 0 };
    private static final int LIMIT = (int) 1e6;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        final Set<String> BLOCKS = new HashSet<>();
        for (int[] block : blocked) {
            BLOCKS.add(hash(block[0], block[1]));
        }

        return bfs(source, target, BLOCKS) && bfs(target, source, BLOCKS);
    }

    private boolean bfs(int[] source, int[] target, final Set<String> BLOCKS) {
        final Set<String> SEEN = new HashSet<>();
        SEEN.add(hash(source[0], source[1]));

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curCol = cur[1];

                for (int d = 0; d < 4; ++d) {
                    int nextRow = curRow + DIRS[d];
                    int nextCol = curCol + DIRS[d + 1];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= LIMIT || nextCol >= LIMIT)
                        continue;

                    String hash = hash(nextRow, nextCol);
                    if (SEEN.contains(hash) || BLOCKS.contains(hash))
                        continue;
                    if (nextRow == target[0] && nextCol == target[1])
                        return true;
                    queue.offer(new int[] { nextRow, nextCol });
                    SEEN.add(hash);
                }

                if (SEEN.size() == 20000)
                    return true;
            }
        }

        return false;
    }

    private String hash(int row, int col) {
        return "" + row + "#" + col;
    }
}
