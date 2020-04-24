/**
 * https://leetcode.com/problems/spiral-matrix
 */

package main.java.lcidiot.lc.lvl3.lc0054;

import java.util.ArrayList;
import java.util.List;

public class Solution{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while(true){
            for(int col = left; col <= right; col++){
                res.add(matrix[top][col]);
            }
            top++;
            if(left > right || top > bottom) break;
            
            for(int row = top; row <= bottom; row++){
                res.add(matrix[row][right]);
            }
            right--;
            if(left > right || top > bottom) break;
            
            for(int col = right; col >= left; col--){
                res.add(matrix[bottom][col]);
            }
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int row = bottom; row >= top; row--){
                res.add(matrix[row][left]);
            }
            left++;
            if(left > right || top > bottom) break;
        }
        
        return res;
    }
    
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(matrix.length == 0) return res;
        
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int j = colBegin; j <= colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            for(int j = rowBegin; j <= rowEnd; j++){
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if(rowBegin <= rowEnd){
                for(int j = colEnd; j >= colBegin; j--){
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if(colBegin <= colEnd){
                for(int j = rowEnd; j >= rowBegin; j--){
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        
        return res;
    }
}