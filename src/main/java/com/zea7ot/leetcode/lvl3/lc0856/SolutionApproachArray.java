/**
 * https://leetcode.com/problems/score-of-parentheses/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * 
 * https://leetcode.com/problems/score-of-parentheses/discuss/141777/C%2B%2BJavaPython-O(1)-Space
 */
package com.zea7ot.leetcode.lvl3.lc0856;

public class SolutionApproachArray {
    public int scoreOfParentheses(String S) {
        int[] ans = new int[30];
        int idx = 0;
        for(char c : S.toCharArray()){
            if(c == '(') ans[++idx] = 0;
            else ans[idx - 1] += Math.max(ans[idx--] * 2, 1);
        }
        return ans[0];
    }
}