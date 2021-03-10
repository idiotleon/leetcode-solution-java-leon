/**
 * https://leetcode.com/problems/design-phone-directory/
 * 
 * 
 */
package com.an7one.leetcode.ood.lvl3.lc0379;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SolutionApproach1QueueAndSet {
    private int max;
    private Set<Integer> used;
    private LinkedList<Integer> released;

    /**
     * Initialize your data structure here
     * 
     * @param maxNumbers - The maximum numbers that can be stored in the phone
     *                   directory.
     */
    public SolutionApproach1QueueAndSet(int maxNumbers) {
        this.max = maxNumbers;
        this.used = new HashSet<Integer>();
        this.released = new LinkedList<Integer>();
    }

    /**
     * Provide a number which is not assigned to anyone.
     * 
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (used.size() == max)
            return -1;
        Integer res = released.isEmpty() ? used.size() : released.remove();
        used.add(res);
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !used.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (used.remove(number))
            released.add(number);
    }
}