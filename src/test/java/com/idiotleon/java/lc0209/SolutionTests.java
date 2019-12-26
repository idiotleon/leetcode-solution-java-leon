package com.idiotleon.java.lc0209;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private final Solution solution = new Solution();

    @DisplayName("The very 1st test case")
    @Test
    void test() {
        assertEquals(2, solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
    }
}