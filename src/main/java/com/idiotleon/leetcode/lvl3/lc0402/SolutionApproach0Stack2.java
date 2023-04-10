/**
 * https://leetcode.com/problems/remove-k-digits/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.idiotleon.leetcode.lvl3.lc0402;

import java.util.LinkedList;

public class SolutionApproach0Stack2 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty() || k < 0)
            return "";
        if (k == 0)
            return num;
        if (k >= num.length())
            return "0";

        LinkedList<Character> stack = new LinkedList<Character>();
        final int L = num.length();

        int idx = 0;
        while (idx < L) {
            char cur = num.charAt(idx);

            while (!stack.isEmpty() && k > 0 && stack.peekLast() > cur) {
                stack.removeLast();
                k--;
            }

            stack.add(cur);

            if (k == 0)
                break;

            idx++;
        }

        while (!stack.isEmpty() && k > 0) {
            stack.removeLast();
            k--;
        }

        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.removeFirst();
        }
        if (stack.isEmpty() && idx == L - 1)
            return "0";

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.removeLast());
        }
        if (idx < L - 1) {
            builder.append(num.substring(idx + 1));
        }

        return builder.toString();
    }
}