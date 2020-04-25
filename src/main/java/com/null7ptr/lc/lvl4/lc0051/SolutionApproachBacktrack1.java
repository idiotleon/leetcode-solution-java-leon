/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Time Complexity: O((N^3) * N!)
 */
package com.null7ptr.lc.lvl4.lc0051;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproachBacktrack1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if(n < 1) return ans;
        
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        
        backtrack(board, 0, ans);
        return ans;
    }

    private void backtrack(char[][] board, 
                           int col, 
                           List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++){
            if(validate(board, i, col)){
                board[i][col] = 'Q';
                backtrack(board, col + 1, res);
                board[i][col] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int row, int col){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'Q' 
                   && (row + j == col + i || row + col == i + j || row == i)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board){
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++){
            String str = new String(board[i]);
            res.add(str);
        }
        
        return res;
    }
}