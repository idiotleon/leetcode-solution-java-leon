/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 * https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
 */
package main.java.lcidiot.lc.lvl5.lc0301;

import java.util.ArrayList;
import java.util.List;

class SolutionApproachDFS3 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<String>();
        dfs(s, output, 0, 0, '(', ')');
        return output;
    }
    
    private void dfs(String s, 
                        List<String> output, 
                        int iStart, 
                        int jStart, 
                        char openParen, 
                        char closedParen){
        int numOpenParen = 0, numClosedParen = 0;
        
        for(int i = iStart; i < s.length(); i++){
            if(s.charAt(i) == openParen) numOpenParen++;
            if(s.charAt(i) == closedParen) numClosedParen++;
            if(numClosedParen > numOpenParen){  // there is an extra closed parenthese to remove
                for(int j = jStart; j <= i; j++){ // to remove one at each position, skipping duplicates
                    if(s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)){
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        dfs(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openParen, closedParen);
                    }
                }
                
                return;
            }
        }
        
        // to check the opposite direction, since no invalid parenthesis can be detected
        String reversed = new StringBuilder(s).reverse().toString();
        if(openParen == '('){
            dfs(reversed, output, 0, 0, ')', '(');
        }else{
            output.add(reversed);
        }
    }
}