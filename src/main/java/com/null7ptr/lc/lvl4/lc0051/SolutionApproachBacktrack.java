/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Time Complexity: O(N * N!)
 */
package com.null7ptr.lc.lvl4.lc0051;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproachBacktrack {
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
        
        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        
        backtrack(board, 0, diag1, diag2, column, n, ans);
        
        return ans;
    }

    private void backtrack(char[][] board, 
                           int idx, 
                           boolean[] diag1,
                           boolean[] diag2,
                           boolean[] column,
                           int n,
                           List<List<String>> res){
        if(idx == board.length){
            res.add(construct(board));
            return;
        }
        
        for(int j = 0; j < n; j++){
            if(column[j] || diag1[idx + n - j - 1] || diag2[idx + j]) continue;
            
            // to prepare for backtrack
            column[j] = true;
            diag1[idx + n - j - 1] = true;
            diag2[idx + j] = true;
            board[idx][j] = 'Q';
            
            // to start backtrack
            backtrack(board, idx + 1, diag1, diag2, column, n, res);
            
            // to put the previous state back
            board[idx][j] = '.';
            column[j] = false;
            diag1[idx + n - j - 1] = false;
            diag2[idx + j] = false;
        }
       
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