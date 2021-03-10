package com.an7one.bycompany.amazon.ood.first_unique_number_in_data_stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.an7one.bycompany.amazon.ood.first_unique_number_in_data_stream.util.Constants;

import org.junit.jupiter.api.Test;

public class TestSolutionApproach0DoublyLinkedList {
    private SolutionApproach0DoublyLinkedList solution = new SolutionApproach0DoublyLinkedList();

    @Test
    void testStreamWithoutAnyDuplicate(){
        int[] stream = {0, 1, 2, 3, 4};
        for(int num : stream) solution.add(num);

        assertEquals(0, solution.getFirstUnique());
    }

    @Test
    void testStreamWithOneDuplicate(){
        int[] stream = {0, 1, 0};
        for(int num : stream) solution.add(num);

        assertEquals(1, solution.getFirstUnique());
    }

    @Test
    void testStreamWithAllDuplicates(){
        int[] stream = {0, 1, 0, 1};
        for(int num : stream) solution.add(num);

        assertEquals(Constants.RESPONSE_IMPOSSIBLE, solution.getFirstUnique());
    }

    @Test
    void testStreamEmpty(){
        int[] stream = new int[0];
        for(int num : stream) solution.add(num);

        assertEquals(Constants.RESPONSE_IMPOSSIBLE, solution.getFirstUnique());
    }
}