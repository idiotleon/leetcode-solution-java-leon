package com.an7one.bycompany.others.matrix.most_connected_pixels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0DFSRecursive {
    private SolutionApproach0DFS1 solution = new SolutionApproach0DFS1();

    @Test
    void test(){
        Pixel pixel1 = new Pixel(1, 1, 1);
        Pixel pixel2 = new Pixel(1, 1, 1);
        Pixel pixel3 = new Pixel(1, 2, 0);
        Pixel pixel4 = new Pixel(1, 2, 0);

        Pixel[][] board = new Pixel[2][2];
        board[0][0] = pixel1;
        board[0][1] = pixel2;
        board[1][0] = pixel3;
        board[1][1] = pixel4;

        assertEquals(4, solution.getMostConnectedPixels(board));
    }
}