/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 * 
 * Time Complexities:
 *  `next()`:       O()
 *  `hasNext()`:    O()
 *  
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/flatten-nested-list-iterator/discuss/80147/Simple-Java-solution-using-a-stack-with-explanation
 */
package com.zea7ot.leetcode.ood.lvl3.lc0341;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import com.zea7ot.utils.NestedInteger;

public class SolutionApproach0Stack implements Iterator<Integer> {
    private Deque<NestedInteger> stack;

    public SolutionApproach0Stack(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque<>();
        flattenNestedList(nestedList);
    }

    @Override
    public Integer next() {
        if (!hasNext())
            return null;

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> list = stack.pop().getList();
            flattenNestedList(list);
        }

        return !stack.isEmpty();
    }

    private void flattenNestedList(List<NestedInteger> nestedList) {
        final int SIZE = nestedList.size();
        for (int i = SIZE - 1; i >= 0; --i)
            stack.push(nestedList.get(i));
    }
}