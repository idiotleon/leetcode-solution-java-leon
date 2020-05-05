/**
 * https://leetcode.com/problems/online-stock-span/
 * 
 * Time Complexity: O(N) ~ O(N ^ 2)
 * Space Complexity: O(1) ~ O(N)
 */
package com.polyg7ot.lc.lvl3.lc0901;

import java.util.LinkedList;

public class SolutionApproachStack {
    private LinkedList<int[]> stack;

    public SolutionApproachStack() {
        this.stack = new LinkedList<int[]>();
    }
    
    public int next(int price) {
        int ans = 1;
        while(!stack.isEmpty() && stack.peekLast()[0] <= price){
            ans += stack.removeLast()[1];
        }
        
        stack.add(new int[]{price, ans});
        
        return ans;
    }
}