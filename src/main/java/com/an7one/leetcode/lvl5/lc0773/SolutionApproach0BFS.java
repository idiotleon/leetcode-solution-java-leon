/**
 * https://leetcode.com/problems/sliding-puzzle/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  
 */
package com.an7one.leetcode.lvl5.lc0773;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0BFS {
    public int slidingPuzzle(int[][] board) {
        // sanity check
        if (board == null || board.length == 0)
            return 0;

        // boundaries of the board
        final int NR = board.length, NC = board[0].length;
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();

        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < NR; ++row) {
            for (int col = 0; col < NC; ++col) {
                builder.append(board[row][col]);
            }
        }

        queue.add(builder.toString());
        visited.add(builder.toString());
        int count = 0;

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int sz = 0; sz < SIZE; ++sz) {
                String curBoard = queue.poll();

                if (curBoard.equals("123450"))
                    return count;

                int pos = curBoard.indexOf('0');
                final int[] DIRS = { -1, 1, -3, 3 };

                for (int d = 0; d < DIRS.length; d++) {
                    int next = pos + DIRS[d];
                    if (next < 0 || next >= curBoard.length())
                        continue;
                    // two edge cases
                    if (pos == 3 && DIRS[d] == -1)
                        continue;
                    if (pos == 2 && DIRS[d] == 1)
                        continue;

                    String nextBoard = swap(pos, next, curBoard);
                    if (!visited.add(nextBoard))
                        continue;
                    queue.add(nextBoard);
                }
            }

            ++count;
        }

        return -1;
    }

    // to swap chars
    private String swap(int i, int j, String str) {
        final char[] CHS = str.toCharArray();
        char temp = CHS[i];
        CHS[i] = CHS[j];
        CHS[j] = temp;

        return new String(CHS);
    }
}