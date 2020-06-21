/**
 * 81. Search in a Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
package com.zea7ot.lc.lvl4.lc0081;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.zea7ot.utils.Constants;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SolutionTestsApproachBinarySearch {
    private SolutionApproach0BinarySearch approachBinarySearch = new SolutionApproach0BinarySearch();

    // @Test
    // void test() {
    //     assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_05, 3));
    // }

    @Test
    void testSortedArrayWithoutDuplicates() {
        assertTrue(approachBinarySearch.search(Constants.Array.SORTED01, 1));
        assertTrue(approachBinarySearch.search(Constants.Array.SORTED01, 3));
        assertTrue(approachBinarySearch.search(Constants.Array.SORTED01, 5));

        assertTrue(approachBinarySearch.search(Constants.Array.SORTED, 1));
    }

    @Test
    void testRotatedSortedArrayWithoutDuplicates() {
        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_01, 1));
        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_01, 3));
        assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_01, 2));
    }

    @Test
    void testRotatedSortedArrayWithDuplicates() {
        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES, 0));
        assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES, 3));

        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_01, 3));
        assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_01, 2));

        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_02, 3));
        assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_02, 2));

        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_03, 3));
        assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_03, 2));

        assertTrue(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_04, 1));
        assertFalse(approachBinarySearch.search(Constants.Array.ROTATED_SORTED_WITH_DUPLICATES_04, 2));
    }

    @Test
    void testSingleElementArray() {
        assertTrue(approachBinarySearch.search(Constants.Array.SINGLE_ELE, 1));
        assertFalse(approachBinarySearch.search(Constants.Array.SINGLE_ELE, 3));
    }

    @Test
    void testSingleElementArrayWithDup() {
        assertTrue(approachBinarySearch.search(Constants.Array.SINGLE_ELE_WITH_DUPLICATES, 1));
        assertFalse(approachBinarySearch.search(Constants.Array.SINGLE_ELE_WITH_DUPLICATES, 3));
    }

    @Test
    void testEmptyArray() {
        assertFalse(approachBinarySearch.search(Constants.Array.EMPTY, 3));
    }

    @Test
    void testNullArray() {
        assertFalse(approachBinarySearch.search(Constants.Array.NULL, 3));
    }
}