/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * Time Complexity:     O(lg(`N`))
 *  in the worst case:  O(`N`)
 *  e.g.: [1,1,1,1,1,1,5], target = 5
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28212/When-there-are-duplicates-the-worst-case-is-O(n).-Could-we-do-better/27225
 */
package com.idiotleon.leetcode.lvl4.lc0081;

public class SolutionApproach0BinarySearch {
    public boolean search(int[] nums, int target) {
        // sanity check
        if (nums == null || nums.length == 0)
            return false;

        final int N = nums.length;
        int lo = 0, hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[lo] < nums[mid]) { // lo half is sorted
                if (nums[mid] > target && nums[lo] <= target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[lo] > nums[mid]) { // hi half is sorted
                if (nums[mid] < target && nums[hi] >= target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            // when nums[lo] == nums[mid],
            // basically having no idea about the array,
            // then to exclude nums[lo] and repeat the above process
            else {
                ++lo;
            }
        }

        return false;
    }
}