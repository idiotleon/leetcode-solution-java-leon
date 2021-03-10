/**
 * https://leetcode.com/problems/score-of-parentheses/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * 
 * https://leetcode.com/problems/score-of-parentheses/discuss/141777/C%2B%2BJavaPython-O(1)-Space
 */
package com.an7one.leetcode.lvl3.lc0856;

public class SolutionApproachOnePass {
    public int scoreOfParentheses(String S) {
        int ans = 0, counter = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(') counter++;
            else counter--;
            
            // depending on how many brackets are still open,
            // the weight/answer once they are closed are different
            if(S.charAt(i) == ')' && S.charAt(i - 1) == '('){
                ans += 1 << counter;
            }
        }
        
        return ans;
    }
}