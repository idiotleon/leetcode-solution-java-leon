/**
 * https://leetcode.com/problems/diagonal-traverse/
 * 
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 * 
 * There will be a situation when we satisfy both these two statements, in case i, 
 * it is at right top corner, in this case, we can only goes down -- \
 * thus it has to first goto "col == n-1" check. 
 * Otherwise if goes to "row == 0" check we will have indexOutOfBound error since we can't do col++;
 * 
 * Similarly, there will be a situation when we satisfy both these two statements, 
 * in case ii, it is at left bottom corner, in this case, 
 * we can only goes right --it has to first goto "row == m-1" check, 
 * Otherwise if goes to "col == 0" check we will have indexOutOfBound error since we can't do row++
 * 
 * https://leetcode.com/problems/diagonal-traverse/discuss/97711/Java-15-lines-without-using-boolean/159357
 */
package com.zea7ot.lc.lvl3.lc0498;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        // sanity check
        if(matrix == null || matrix.length == 0) return new int[0];
        
        final int NR = matrix.length, NC = matrix[0].length;
        int[] res = new int[NR * NC];
    
        int row = 0, col = 0, idx = 0;
        while(idx < NR * NC){
            res[idx++] = matrix[row][col];
            
            if((row + col) % 2 == 0){   // moving up
                if(col == NC - 1) row++;
                else if(row == 0) col++;
                else{
                    row--;
                    col++;
                }
            }else{  // moving down
                if(row == NR - 1) col++;
                else if(col == 0) row++;
                else{
                    row++;
                    col--;
                }
            }
        }
        
        return res;
    }
}