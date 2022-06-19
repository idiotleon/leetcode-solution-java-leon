package com.an7one.bycompany.others.matrix.hungary_rabbit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.an7one.bycompany.others.matrix.hungry_rabbit.SolutionApproach0DFSRecursive;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0DFSRecursiveRecursive {
    private SolutionApproach0DFSRecursive solution = new SolutionApproach0DFSRecursive();

    @Test
    void test() {
        final int[][] SAMPLE = { { 5, 7, 8, 6, 3 }, { 0, 0, 7, 0, 4 }, { 4, 6, 3, 4, 9 }, { 3, 1, 0, 5, 8 } };
        final int EXPECTED = 27;
        assertEquals(EXPECTED, solution.greedilyEatCarrots(SAMPLE));
    }
}