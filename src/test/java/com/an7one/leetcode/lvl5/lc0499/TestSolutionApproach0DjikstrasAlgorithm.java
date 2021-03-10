package com.an7one.leetcode.lvl5.lc0499;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0DjikstrasAlgorithm {
    private SolutionApproach0DijkstrasSPF solution = new SolutionApproach0DijkstrasSPF();

    @Test
    void test() {
        final int[][] MAZE = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0 } };

        final int[] BALL = { 4, 3 };

        final int[] HOLE = { 0, 1 };

        final String EXPECTED = "lul";

        assertEquals(EXPECTED, solution.findShortestWay(MAZE, BALL, HOLE));
    }
}