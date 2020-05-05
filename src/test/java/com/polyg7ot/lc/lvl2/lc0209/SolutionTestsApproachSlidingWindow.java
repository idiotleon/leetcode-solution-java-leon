package com.polyg7ot.lc.lvl2.lc0209;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.polyg7ot.lc.utils.Constants;

class SolutionTestsApproachSlidingWindow {
    private final SolutionApproachSlidngWindow approachSlidngWindow = new SolutionApproachSlidngWindow();

    @Test
    @DisplayName("209. Minimum Size Subarray Sum")
    void test() {
        assertEquals(2, approachSlidngWindow.minSubArrayLen(7, Constants.Array.RANDOM));
    }
}