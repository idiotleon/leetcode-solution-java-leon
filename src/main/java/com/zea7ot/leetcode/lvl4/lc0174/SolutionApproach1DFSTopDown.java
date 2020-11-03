/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * Time Compelxity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/dungeon-game/
 */
package com.zea7ot.leetcode.lvl4.lc0174;

public class SolutionApproach1DFSTopDown {
    private int[][] cache;
    private int NR, NC;

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        this.NR = dungeon.length;
        this.NC = dungeon[0].length;
        this.cache = new int[NR][NC];

        return dfs(dungeon, 0, 0);
    }

    private int dfs(int[][] dungeon, int row, int col) {
        if (row >= NR || col >= NC)
            return Integer.MAX_VALUE;
        if (cache[row][col] > 0)
            return cache[row][col];

        int health = Integer.MAX_VALUE;
        health = Math.min(health, dfs(dungeon, row + 1, col));
        health = Math.min(health, dfs(dungeon, row, col + 1));
        // this only happens with row, col
        health = health == Integer.MAX_VALUE ? 1 : health;

        int ans = health > dungeon[row][col] ? (health - dungeon[row][col]) : 1;
        cache[row][col] = ans;
        return ans;
    }
}