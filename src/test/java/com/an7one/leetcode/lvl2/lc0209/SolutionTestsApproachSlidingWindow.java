package com.an7one.leetcode.lvl2.lc0209;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.an7one.util.Constants;

class SolutionTestsApproachSlidingWindow {
    private final SolutionApproach0SlidingWindow solution = new SolutionApproach0SlidingWindow();

    @Test
    @DisplayName("209. Minimum Size Subarray Sum")
    void test() {
        assertEquals(2, solution.minSubArrayLen(7, Constants.Array.RANDOM));
    }
}