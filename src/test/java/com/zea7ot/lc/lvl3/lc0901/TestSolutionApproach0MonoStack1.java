package com.zea7ot.lc.lvl3.lc0901;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestSolutionApproach0MonoStack1 {
    private final SolutionApproach0MonoStack1 solution = new SolutionApproach0MonoStack1();

    /**
     * ["StockSpanner","next","next","next","next","next","next","next"]
     * [[],[100],[80],[60],[70],[60],[75],[85]]
     */
    @Test
    @Disabled
    void test(){
        assertEquals(1, solution.next(100));
        assertEquals(1, solution.next(80));
        assertEquals(1, solution.next(60));
        assertEquals(2, solution.next(70));
        assertEquals(1, solution.next(60));
        assertEquals(4, solution.next(75));
        assertEquals(6, solution.next(85));
    }
}