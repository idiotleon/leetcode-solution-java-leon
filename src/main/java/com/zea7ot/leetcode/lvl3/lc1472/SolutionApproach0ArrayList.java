/**
 * @author: Leon
 * https://leetcode.com/problems/design-browser-history/
 * 
 * Time Complexities:
 *  visit:      O(L)
 *  back:       O(1)
 *  forward:    O(1)
 * 
 * Space Complexities:  O(N)
 *  N, the size of the history
 */
package com.zea7ot.leetcode.lvl3.lc1472;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0ArrayList {
    private List<String> history;
    private int idx;

    public SolutionApproach0ArrayList(String homepage) {
        this.history = new ArrayList<String>();
        this.idx = 0;
        history.add(homepage);
    }
    
    public void visit(String url) {
        history.subList(idx + 1, history.size()).clear();
        history.add(url);
        idx++;
    }
    
    public String back(int steps) {
        idx = Math.max(0, idx - steps);
        return history.get(idx);
    }
    
    public String forward(int steps) {
        final int L = history.size();
        idx = Math.min(L - 1, idx + steps);
        return history.get(idx);
    }
}