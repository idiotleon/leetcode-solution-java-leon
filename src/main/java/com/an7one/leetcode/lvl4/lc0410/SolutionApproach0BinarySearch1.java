/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * Time Complexity:     O(N * lg(sum(nums) - max(nums))) ~ O(N * lg(sum(nums)))
 *  N, the total amount of elements
 *  sum(nums) - max(nums), the search range
 * 
 * Space Complexity:    O(1)
 * 
 * #BinarySearch
 * #Greedy
 * 
 * The answer must be in the range:
 * Lower Bound: max value of nums
 *  this means, no matter what nums, m is, how nums is going to be splitted, 
 *  the min value of largest sum always is bigger than the largest value in nums
 * 
 * Upper Bound: sum of nums (plus 1, depending on whether the last value is exclusive or inclusive)
 *  this means, no matter what nums, m is, how nums is going to be splitted, 
 *  the min value of largest sum always is smaller than the total sum of nums
 * 
 * Given a candidate C, to compute the number groups k needed
 * 
 * if k > m: C is too small
 *  lo = C + 1
 * else
 *  hi = C
 * 
 * References: 
 *  https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation:-8ms-Binary-Search-Java/94310
 *  https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
 *  https://youtu.be/_k-Jb4b7b_0
 *  http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-410-split-array-largest-sum/
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/494896
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/380399
 *  https://leetcode.com/problems/divide-chocolate/discuss/408503/JavaC++Python-Binary-Search/394052
 */
package com.an7one.leetcode.lvl4.lc0410;

public class SolutionApproach0BinarySearch1 {
    public int splitArray(int[] nums, int m) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        long lo = 0, hi = 0;
        for (int num : nums) {
            // the max value
            lo = Math.max(lo, num);
            // the sum
            hi += num;
        }

        if (m == 1)
            return (int) hi;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (isValidSplit(mid, nums, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int) lo;
    }

    private boolean isValidSplit(final long LIMIT, int[] nums, int m) {
        long sum = 0;
        int groups = 1;
        for (int num : nums) {
            if (sum + num > LIMIT) {
                // to reset the counter
                sum = num;
                if (++groups > m)
                    return false;
            } else {
                sum += num;
            }
        }

        return true;
    }
}