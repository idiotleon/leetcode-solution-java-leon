/**
 * https://leetcode.com/problems/surrounded-regions/
 */
package main.java.lcidiot.lc0130;

class SolutionApproachDFS {
    private int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int nr = 0, nc = 0;
    
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        
        nr = board.length;
        nc = board[0].length;
        
        for(int row = 0; row < nr; row++)
            for(int col = 0; col < nc; col++)
                if(board[row][col] == 'O')
                    if(!isBorderAttached(board, row, col))
                        mark(board, row, col, 'X');
                    else
                        mark(board, row, col, 'O');
    }
    
    private void mark(char[][] board, int row, int col, char marker){
        if(row < 0 || col < 0 || row >= nr || col >= nc || board[row][col] != 'Q') return;
        
        board[row][col] = marker;
        
        for(int[] dir : DIRS)
            mark(board, row + dir[0], col + dir[1], marker);
    }
    
    private boolean isBorderAttached(char[][] board, int row, int col){
        if(row < 0 || row >= nr || col < 0 || col >= nc || board[row][col] != 'O') return false;
        
        if(board[row][col] == 'O' && (row == 0 || col == 0 || row == nr - 1 || col == nc - 1)) return true;
        
        board[row][col] = 'Q';
        
        return isBorderAttached(board, row - 1, col) 
            || isBorderAttached(board, row + 1, col) 
            || isBorderAttached(board, row, col - 1) 
            || isBorderAttached(board, row, col + 1);
    }
}