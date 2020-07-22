/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 * 
 * Time Complexity:     O()
 * Space Complexiyt:    O()
 * 
 * References:
 *  https://leetcode.com/problems/filling-bookcase-shelves/discuss/323305/C++-4-lines-DFS-+-Memo/526109
 */
package com.zea7ot.lc.lvl4.lc1105;

public class SolutionApproach1DFSMemo {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        final int RANGE = 1001;
        int[][] memo = new int[RANGE][RANGE];
        return minHeightShelves(0, 0, 0, shelfWidth, books, memo);
    }
    
    private int minHeightShelves(int idx, 
                                 int width, 
                                 int height, 
                                 int maxWidth, 
                                 int[][] books, 
                                 int[][] memo){
        if(idx >= books.length) return height;
        if(memo[idx][width] != 0) return memo[idx][width];
        return memo[idx][width] = Math.min(height + minHeightShelves(idx + 1, books[idx][0], books[idx][1], maxWidth, books, memo),
                width + books[idx][0] > maxWidth ? Integer.MAX_VALUE : minHeightShelves(idx + 1, width + books[idx][0], Math.max(height, books[idx][1]), maxWidth, books, memo));
    }
}