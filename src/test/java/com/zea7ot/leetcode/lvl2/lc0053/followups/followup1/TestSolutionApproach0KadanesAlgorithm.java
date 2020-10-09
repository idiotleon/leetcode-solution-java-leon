package com.zea7ot.leetcode.lvl2.lc0053.followups.followup1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0KadanesAlgorithm {
    private SolutionApproach0KadanesAlgorithm solution = new SolutionApproach0KadanesAlgorithm();

    @Test
    void lengthOfMaxSubArray_RegularArray_ShouldReturnExpected() {
        int[] input = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int expected = 4;

        assertEquals(expected, solution.lengthOfMaxSubArray(input));
    }


    @Test
    void startingPosOfMaxSubArray_SingleNegativeElement_ShouldReturn0() {
        int[] input = { -1 };
        int expected = 1;

        assertEquals(expected, solution.lengthOfMaxSubArray(input));
    }

    @Test
    void startingPosOfMaxSubArray_SingleElementZero_ShouldReturn0() {
        int[] input = { 0 };
        int expected = 1;

        assertEquals(expected, solution.lengthOfMaxSubArray(input));
    }

    @Test
    void startingPosOfMaxSubArray_SinglePositiveElement_ShouldReturn0() {
        int[] input = { 1 };
        int expected = 1;

        assertEquals(expected, solution.lengthOfMaxSubArray(input));
    }
}
