/**
 * https://leetcode.com/problems/minesweeper/
 */
package com.idiotleon.leetcode.lvl4.lc0529;

import java.util.LinkedList;

public class SolutionApproachBFS1 {
    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    
    private int NR, NC;
    
    public char[][] updateBoard(char[][] board, int[] click) {
        // sanity check
        if(board == null || board.length == 0 || click == null || click.length == 0) return board;
        
        // boudaries of the board
        NR = board.length;
        NC = board[0].length;
        
        boolean found = false;
        // to detect whether there is ever a mine
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == 'M'){
                    found = true;
                    break;
                }
            }
        }
        
        // if there is no mine at all
        if(!found){
            for(int row = 0; row < NR; row++){
                for(int col = 0; col < NC; col++){
                    board[row][col] = 'B';
                }
            }
            
            return board;
        }
        
        int[][] mines = constructMinesBoard(board);
        
        // to BFS the original board
        switch(board[click[0]][click[1]]){
            case 'M':
                board[click[0]][click[1]] = 'X';
                return board;
            case 'B':
            // case 1~8
                return board;
            case 'E':
                bfs(board, mines, click);
                break;
        }
        
        return board;
    }
    
    // to sweep mines
    private void bfs(char[][] board, int[][] mines, int[] click){
        if(board[click[0]][click[1]] != 'E') return;
        
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.add(click);
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; i++){
                int[] cur = queue.removeFirst();
                int row = cur[0], col = cur[1];
                
                if(mines[row][col] == 0){
                    board[row][col] = 'B';
                    
                    for(int[] dir : DIRS){
                        int r = row + dir[0], c = col + dir[1];
                        if(r >= 0 && r < NR && c >= 0 && c < NC){
                            if(board[r][c] == 'E'){
                                queue.add(new int[]{r, c});
                            }
                        }
                    }
                }else{
                    board[row][col] = (char)(mines[row][col] + '0');
                }
            }
        }
    }
    
    // to create a board of mines
    private int[][] constructMinesBoard(char[][] board){
        int[][] mines = new int[NR][NC];
        LinkedList<int[]> queue = new LinkedList<int[]>();
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] == 'M'){
                    mines[row][col] = -1;
                    queue.add(new int[]{row, col});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.removeFirst();
            int row = cur[0], col = cur[1];
            
            for(int[] dir : DIRS){
                int r = row + dir[0], c = col + dir[1];
                if(r >= 0 && r < NR && c >= 0 && c < NC){
                    if(board[r][c] == 'E' || board[r][c] == 'B'){
                        ++mines[r][c];
                    }
                }
            }
        }
        
        return mines;
    }
}