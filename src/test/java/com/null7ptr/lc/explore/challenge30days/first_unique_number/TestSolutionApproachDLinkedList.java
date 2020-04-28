package com.null7ptr.lc.explore.challenge30days.first_unique_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSolutionApproachDLinkedList {

    @Test
    void testExample1(){
        SolutionApproachDLinkedList solution = new SolutionApproachDLinkedList(new int[]{2,3,5});
        solution.add(3);
        assertEquals(2, solution.showFirstUnique());

        solution.add(2);
        assertEquals(5,  solution.showFirstUnique());

        solution.add(5);
        assertEquals(-1, solution.showFirstUnique());
    }

    @Test
    void testExample2(){
        SolutionApproachDLinkedList solution = new SolutionApproachDLinkedList(new int[]{7,7,7,7,7,7});
        assertEquals(-1, solution.showFirstUnique());

        solution.add(3);
        solution.add(3);
        solution.add(7);
        solution.add(17);
        assertEquals(17,  solution.showFirstUnique());
    }
}