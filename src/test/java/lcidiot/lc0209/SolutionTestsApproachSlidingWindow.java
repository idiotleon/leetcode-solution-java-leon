package test.java.lcidiot.lc0209;

import org.junit.jupiter.api.Test;

import test.java.lcidiot.utils.Constants;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTestsApproachSlidingWindow {
    private final SolutionApproachSlidngWindow approachSlidngWindow = new SolutionApproachSlidngWindow();

    @Test
    @DisplayName("209. Minimum Size Subarray Sum")
    void test() {
        assertEquals(2, approachSlidngWindow.minSubArrayLen(7, Constants.Array.RANDOM));
    }
}