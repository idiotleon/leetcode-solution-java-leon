/**
 * https://leetcode.com/problems/dungeon-game/
 * 
 * Time Complexity:
 * Space Complexity:
 * 
 * References:
 *  https://leetcode.com/problems/dungeon-game/discuss/52790/My-AC-Java-Version-Suggestions-are-welcome/183618
 */
package com.zea7ot.leetcode.lvl4.lc0174;

public class SolutionApproach1DFSTopDown1 {
    private int[][] cache;
    private int NR, NC;
    
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        this.NR = dungeon.length;
        this.NC = dungeon[0].length;
        this.cache = new int[NR][NC];
        
        return dfs(dungeon, 0, 0);
    }
    
    private int dfs(int[][] dungeon, int row, int col){
        if(row >= NR || col >= NC) return Integer.MAX_VALUE;
        if(cache[row][col] > 0) return cache[row][col];
        
        int nextHealth = Math.min(dfs(dungeon, row + 1, col), dfs(dungeon, row, col + 1));
        if(nextHealth == Integer.MAX_VALUE) nextHealth = 1;
        int health = (nextHealth > dungeon[row][col]) ? (nextHealth - dungeon[row][col]) : 1;
        
        cache[row][col] = health;
        return health;
    }
}