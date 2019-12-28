package com.idiotleon.java.lc0153;

import com.idiotleon.java.utils.Constants;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;;

public class SolutionTestsApproachBinarySearch {
    private final SolutionApproachBinarySearch approachBinarySearch = new SolutionApproachBinarySearch();

    @Test
    void test() {
        assertEquals(1, approachBinarySearch.findMin(Constants.Array.ROATED_SORTED_01));
        assertEquals(0, approachBinarySearch.findMin(Constants.Array.ROATED_SORTED_02));

        assertEquals(1, approachBinarySearch.findMin(Constants.Array.SORTED));
    }

    @Test
    void testEmptyMatrix() {
        assertEquals(-1, approachBinarySearch.findMin(Constants.Array.EMPTY));
    }
}