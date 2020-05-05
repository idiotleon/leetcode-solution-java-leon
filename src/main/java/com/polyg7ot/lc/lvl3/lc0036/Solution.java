/**
 * https://leetcode.com/problems/valid-sudoku/
 */
package com.polyg7ot.lc.lvl3.lc0036;

import java.util.HashSet;
import java.util.Set;

public class Solution{
   public boolean isValidSudoku(char[][] board){
       Set<String> seen = new HashSet<String>();
       for(int i = 0; i < 9; i++){
           for(int j = 0; j < 9; j++){
               char number = board[i][j];
               if(number != '.'){
               if(!seen.add(number + " in row " + i)
                || !seen.add(number + " in column " + j)
                || !seen.add(number + " in block " + i/3 + "-" + j/3)) 
                    return false;
               }
            }
        }
        
        return true;
    }

public boolean isValidSudoku2(char[][] board) {
    for(int i = 0; i < 9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        
        for(int j = 0; j < 9; j++){
            if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
            if(board[j][i] != '.' && !columns.add(board[j][i])) return false;
            int rowIndex = 3 * (i / 3), colIndex = 3 * (i % 3);
            if(board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) return false;
        }
    }
        
    return true;
}

public boolean isValidSudoku3(char[][] board){
    Set<String> seen = new HashSet<String>();
    for(int i = 0; i < 9; ++i){
        for(int j = 0; j < 9; ++j){
            if(board[i][j] != '.'){
                String b = "(" + board[i][j] + ")";
                if(!seen.add(b + i) 
                   || !seen.add(j + b) 
                   || !seen.add(i / 3 + b + j / 3))
                    return false;
            }
        }
    }
    
    return true;
    }
}