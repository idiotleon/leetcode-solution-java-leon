/**
 * https://leetcode.com/problems/online-stock-span/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * !!!incorrect:
 * counts of last larger numbers are bigger by one
 */
package com.zea7ot.lc.lvl3.lc0901;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolutionApproachStack1 {
    private List<Integer> prices;
    private Stack<Integer> idxStack;

    public SolutionApproachStack1() {
        prices = new ArrayList<Integer>();
        idxStack = new Stack<Integer>();
    }
    
    public int next(int price) {   
        final int L = prices.size();
        
        int count = 1;
        while(!idxStack.isEmpty() && prices.get(idxStack.peek()) <= price){
            count += L - idxStack.pop();
        }

        prices.add(price);
        idxStack.push(L);
        return count;
    }
}