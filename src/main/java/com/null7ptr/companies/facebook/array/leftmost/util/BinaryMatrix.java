package com.null7ptr.companies.facebook.array.leftmost.util;

import java.util.Arrays;
import java.util.List;

public class BinaryMatrix {
    int[][] matrix;

    public BinaryMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    public int get(int row, int col){
        return matrix[row][col];
    }

    public List<Integer> dimensions(){
        return Arrays.asList(matrix.length, matrix[0].length);
    }
}