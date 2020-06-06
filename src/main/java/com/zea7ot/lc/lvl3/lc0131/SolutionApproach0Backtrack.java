/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.lc.lvl3.lc0131;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<String>(), s, 0);
        return ans;
    }
    
    private void backtrack(List<List<String>> ans, 
                           List<String> intermediate, 
                           String str, 
                           int startPos){
        if(startPos == str.length()){
            ans.add(new ArrayList<String>(intermediate));
            return;
        }
        
        for(int i = startPos; i < str.length(); i++){
            if(isPalindrome(str, startPos, i)){
                intermediate.add(str.substring(startPos, i + 1));
                backtrack(ans, intermediate, str, i + 1);
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int left, int right){
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        
        return true;
    }
}