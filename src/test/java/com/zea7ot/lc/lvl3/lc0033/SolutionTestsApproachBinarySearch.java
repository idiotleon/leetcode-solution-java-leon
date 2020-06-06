/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). You
 * are given a target value to search. If found in the array return its index,
 * otherwise return -1. You may assume no duplicate exists in the array. Your
 * algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1: Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 * 
 * Example 2: Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */
package com.zea7ot.lc.lvl3.lc0033;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zea7ot.lc.utils.Constants;

public class SolutionTestsApproachBinarySearch {
    private final SolutionApproach0BinarySearch approachBinarySearch = new SolutionApproach0BinarySearch();

    @Test
    void test() {
        assertEquals(0, approachBinarySearch.search(Constants.Array.ROTATED_SORTED_01, 1));
        assertEquals(4, approachBinarySearch.search(Constants.Array.ROTATED_SORTED_02, 0));
        assertEquals(1, approachBinarySearch.search(Constants.Array.ROTATED_SORTED_03, 1));
        assertEquals(0, approachBinarySearch.search(Constants.Array.ROTATED_SORTED_04, 3));
    }

    @Test
    void testSingleEle() {
        assertEquals(0, approachBinarySearch.search(Constants.Array.SINGLE_ELE, 1));
        assertEquals(-1, approachBinarySearch.search(Constants.Array.SINGLE_ELE, 2));
    }
}