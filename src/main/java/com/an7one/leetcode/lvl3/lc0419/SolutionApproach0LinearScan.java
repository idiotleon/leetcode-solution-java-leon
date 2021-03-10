/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(1)
 * 
 * Referenfeces:
 *  https://leetcode.com/problems/battleships-in-a-board/discuss/90902/Simple-Java-Solution
 */
package com.an7one.leetcode.lvl3.lc0419;

public class SolutionApproach0LinearScan {
    public int countBattleships(char[][] board) {
        // sanity check
        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;

        final int NR = board.length, NC = board[0].length;

        int count = 0;
        for (int row = 0; row < NR; row++) {
            for (int col = 0; col < NC; col++) {
                if (board[row][col] == '.')
                    continue;
                if (row > 0 && board[row - 1][col] == 'X')
                    continue;
                if (col > 0 && board[row][col - 1] == 'X')
                    continue;
                count++;
            }
        }

        return count;
    }
}