package com.zea7ot.leetcode.lvl4.lc0042.followup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0Stack {
    private SolutionApproach0MonoStack solution = new SolutionApproach0MonoStack();

    @Test
    void test1(){
        final int [] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(1, solution.trap(heights));
    }
}   