package com.an7one.leetcode.lvl4.lc0031.followups;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0Math {
    private SolutionApproach0Math solution = new SolutionApproach0Math();

    @Test
    void test1() {
        final int[] NUMS = { 1, 3, 2 };
        solution.previousPermutation(NUMS);
        assertArrayEquals(new int[] { 1, 2, 3 }, NUMS);
    }

    @Test
    void test2() {
        final int[] NUMS = { 3, 1, 2 };
        solution.previousPermutation(NUMS);
        assertArrayEquals(new int[] { 2, 3, 1 }, NUMS);
    }

    @Test
    void test3() {
        final int[] NUMS = { 1, 2, 3 };
        solution.previousPermutation(NUMS);
        assertArrayEquals(new int[] { 3, 2, 1 }, NUMS);
    }
}