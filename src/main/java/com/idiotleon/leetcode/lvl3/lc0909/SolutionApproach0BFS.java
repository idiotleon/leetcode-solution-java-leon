/**
 * https://leetcode.com/problems/snakes-and-ladders/
 * 
 * Time Complexity:     O(NR * NC)
 * Space Complexity:    O(NR * NC)
 * 
 * References:
 *  https://leetcode.com/problems/snakes-and-ladders/discuss/173403/Change-to-1D-array-then-BFS/291354
 *  https://leetcode.com/problems/snakes-and-ladders/discuss/173403/Change-to-1D-array-then-BFS
 */
package com.idiotleon.leetcode.lvl3.lc0909;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionApproach0BFS {
    private int NR, NC;
    
    public int snakesAndLadders(int[][] board) {
        // sanity check
        if(board == null || board.length == 0 || board[0].length == 0) return 0;
        
        // N * N matrix
        this.NR = this.NC = board.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        boolean[] seen = new boolean[NR * NC + 1];
        seen[1] = true;
        int steps = 1;
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            for(int i = 0; i < SIZE; i++){
                int top = queue.poll();
                for(int dice = 1; dice <= 6; dice++){
                    int next = top + dice;
                    int[] pos = numToPos(next);
                    int row = pos[0], col = pos[1];
                    if(board[row][col] > 0) next = board[row][col];
                    
                    if(next == NR * NC) return steps;
                    
                    if(!seen[next]){
                        queue.offer(next);
                        seen[next] = true;
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
    
    private int[] numToPos(int num){
        int row = (num - 1) / NC, col = (num - 1) % NC;
        int x = NR - 1 - row;
        int y = row % 2 == 0 ? col : NC - 1 - col;
        return new int[]{x, y};
    }
    
    @SuppressWarnings("unused")
    private int posToNum(int[] position){
        int row = (NR - 1 - position[0]);
        int col = row % 2 == 0 ? position[1] + 1 : NC - position[1];
        return row * NC + col;
    }
}