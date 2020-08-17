
/**
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * Analysis: One can use KMP to track the string and match from back to front until two pointers met, 
 * the back position deduct the front position is the characters we want to patch.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.zea7ot.leetcode.lvl5.lc0214;

public class SolutionApproachKMP {
    public String shortestPalindrome(String s) {
        String ans = "";
        if(s == null || s.isEmpty()) return ans;
        
        final int L = s.length();
        int[] kmpTable = new int[L];
        
        int i = 1, j = 0;
        while(i < L){
            if(s.charAt(i) == s.charAt(j)){
                kmpTable[i++] = ++j;
            }else if(j == 0){
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }
        
        i = 0;
        j = 0;
        while(i + j < L){
            if(s.charAt(j) == s.charAt(L - 1 - i)){
                i++;
                j++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = kmpTable[j - 1];
                }
            }
        }
        
        i -= j;
        for(int k = 0; k < i; k++){
            ans += s.charAt(L - 1 - k);
        }
        ans += s;
        return ans;
    }
}