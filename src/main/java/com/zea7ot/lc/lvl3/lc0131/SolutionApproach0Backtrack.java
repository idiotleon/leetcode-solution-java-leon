/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Time Complexity:     O((2 ^ N) * (N ^ 2))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *  https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution
 */
package com.zea7ot.lc.lvl3.lc0131;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if(s == null || s.isEmpty()) return ans;

        backtrack(new ArrayList<String>(), 0, s, ans);
        return ans;
    }
    
    private void backtrack(List<String> intermediate, 
                           int startPos, 
                           String str,
                           List<List<String>> res){
        final int L = str.length();
        if(startPos == L){
            res.add(new ArrayList<String>(intermediate));
            return;
        }
        
        for(int i = startPos; i < L; i++){
            if(isPalindrome(str, startPos, i)){
                intermediate.add(str.substring(startPos, i + 1));
                backtrack(intermediate, i + 1, str, res);
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int lo, int hi){
        char[] chs = str.toCharArray();
        while(lo < hi){
            if(chs[lo++] != chs[hi--]){
                return false;
            }
        }
        
        return true;
    }
}