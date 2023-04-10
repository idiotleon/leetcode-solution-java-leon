/**
 * https://leetcode.com/problems/alphabet-board-path/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 * 
 * References:
 *  https://leetcode.com/problems/alphabet-board-path/discuss/345312/Java-clean-and-short-solution-easy-to-understand/714264
 *  https://leetcode.com/problems/alphabet-board-path/discuss/345312/Java-clean-and-short-solution-easy-to-understand/330873
 *  https://leetcode.com/problems/alphabet-board-path/discuss/345235/Python-Easy-Solution/313481
 *  https://leetcode.com/problems/alphabet-board-path/discuss/345312/Java-clean-and-short-solution-easy-to-understand
 */
package com.idiotleon.leetcode.lvl3.lc1138;

public class SolutionApproach0ParsingString {
    public String alphabetBoardPath(String target) {
        StringBuilder builder = new StringBuilder();
        int prevRow = 0, prevCol = 0;

        for (final char CH : target.toCharArray()) {
            // to find the position on the board
            int curRow = (CH - 'a') / 5;
            int curCol = (CH - 'a') % 5;
            printPath(builder, prevRow, prevCol, curRow, curCol);
            builder.append('!');
            prevRow = curRow;
            prevCol = curCol;
        }

        return builder.toString();
    }

    // 'U' must come before 'R'
    // 'L' must come before 'D'
    // which result in: "L D U R", or "U R L D"
    private void printPath(StringBuilder builder, int prevRow, int prevCol, int curRow, int curCol) {
        while (curRow < prevRow) {
            builder.append('U');
            --prevRow;
        }

        while (curCol > prevCol) {
            builder.append('R');
            ++prevCol;
        }

        while (curCol < prevCol) {
            builder.append('L');
            --prevCol;
        }

        while (curRow > prevRow) {
            builder.append('D');
            ++prevRow;
        }
    }
}
