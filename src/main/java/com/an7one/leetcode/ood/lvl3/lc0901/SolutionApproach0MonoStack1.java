/**
 * https://leetcode.com/problems/online-stock-span/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * !!!incorrect:
 * counts of last larger numbers are bigger by one
 */
package com.an7one.leetcode.ood.lvl3.lc0901;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionApproach0MonoStack1 {
    private List<Integer> prices;
    private Deque<Integer> idxStack;

    public SolutionApproach0MonoStack1() {
        prices = new ArrayList<Integer>();
        idxStack = new ArrayDeque<>();
    }

    public int next(int price) {
        final int L = prices.size();

        int count = 1;
        while (!idxStack.isEmpty() && prices.get(idxStack.peek()) <= price) {
            count += L - idxStack.pop();
        }

        prices.add(price);
        idxStack.push(L);
        return count;
    }
}