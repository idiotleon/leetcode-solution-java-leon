/**
 * https://leetcode.com/problems/largest-number/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl4.lc0179;

import java.util.PriorityQueue;

public class SolutionApproach0MaxHeap {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";
        if (containsOnlyZeros(nums))
            return "0";

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int num : nums) {
            maxHeap.offer(String.valueOf(num));
        }

        StringBuilder builder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            builder.append(maxHeap.poll());
        }

        return trimZero(builder.toString());
    }

    private boolean containsOnlyZeros(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    private String trimZero(String str) {
        for (final char CH : str.toCharArray()) {
            if (CH != '0') {
                return str;
            }
        }

        return "0";
    }
}