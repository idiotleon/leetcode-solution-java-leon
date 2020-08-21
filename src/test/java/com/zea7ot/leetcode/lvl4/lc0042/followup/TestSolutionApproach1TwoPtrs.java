package com.zea7ot.leetcode.lvl4.lc0042.followup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach1TwoPtrs {
    private SolutionApproach1TwoPtrs solution = new SolutionApproach1TwoPtrs();

    @Test
    void test1(){
        final int [] HEIGHTS = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(1, solution.trap(HEIGHTS));
    }
}   