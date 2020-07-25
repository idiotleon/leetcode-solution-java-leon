/**
 * Given a source string and a target string, find the start index of the first anagram of the target string. 
 * string A is the anagram of string B means A has the same letter distribution with B, f
 * or example: "cat" has the following anagram: "cat", "cta", "act", "atc", "tca", "tac"
 * 
 * For example:
 * source: "banana", target: "na" -> return 1
 * source: "important", target: "ant" -> return 5
 * source: "verygood", target:"god" -> return -1. Even though "g", "o", "d" exists in "verygood"
 */
package com.zea7ot.by_companies.facebook.string.first_index_of_anagram;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSolutionApproachSlidingWindow {
    private SolutionApproachSlidingWindow solution = new SolutionApproachSlidingWindow();

    @Test
    void testExample1(){
        int idx = solution.firstIndexOfAnagram("banana", "na");
        assertEquals(1, idx);
    }

    @Test
    void testExample2(){
        int idx = solution.firstIndexOfAnagram("important", "ant");
        assertEquals(5, idx);
    }

    @Test
    void testExample3(){
        int idx = solution.firstIndexOfAnagram("verygood", "god");
        assertEquals(-1, idx);
    }
}