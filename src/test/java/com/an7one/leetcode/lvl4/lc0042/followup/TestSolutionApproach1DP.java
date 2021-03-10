package com.an7one.leetcode.lvl4.lc0042.followup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach1DP {
    private SolutionApproach1DP solution = new SolutionApproach1DP();

    @Test
    void test1(){
        final int [] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(1, solution.trap(heights));
    }
}   