/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). Find
 * the minimum element.
 * 
 * You may assume no duplicate exists in the array. 
 * Example 1: 
 * Input:
 * [3,4,5,1,2] 
 * Output: 1 
 * 
 * Example 2:
 * Input: [4,5,6,7,0,1,2] 
 * Output: 0
 */

package com.idiotleon.java.lc0153;

import com.idiotleon.java.utils.Constants;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;;

public class SolutionTestsApproachBinarySearch {
    private final SolutionApproachBinarySearch approachBinarySearch = new SolutionApproachBinarySearch();

    @Test
    void test() {
        assertEquals(1, approachBinarySearch.findMin(Constants.Array.ROTATED_SORTED));
        assertEquals(0, approachBinarySearch.findMin(Constants.Array.ROTATED_SORTED_02));

        assertEquals(0, approachBinarySearch.findMin(Constants.Array.ROTATED_SORTED_02));

        assertEquals(1, approachBinarySearch.findMin(Constants.Array.SORTED));
    }

    @Test
    void testSingleArray() {
        assertEquals(1, approachBinarySearch.findMin(Constants.Array.SINGLE_ELE));
    }

    @Test
    void testEmptyArray() {
        assertEquals(-1, approachBinarySearch.findMin(Constants.Array.EMPTY));
    }
}