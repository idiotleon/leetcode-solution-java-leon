/**
 * https://leetcode.com/problems/prefix-and-suffix-search/
 */
package com.an7one.leetcode.lvl4.lc0745;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestSolutionApproach0Trie {
    private UnfinishedSolutionApproach0Trie solution;
    
    @Test
    @Disabled
    public void test(){
        String[] input = new String[]{"apple"};
        solution = new UnfinishedSolutionApproach0Trie(input);

        assertEquals(0, solution.f("a", "e"));
        assertEquals(-1, solution.f("b", ""));
    }
}