/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/107720/C%2B%2BJavaPython-Easy-and-Concise
 * https://leetcode.com/problems/valid-palindrome-ii/discuss/119188/C++-Easy-to-Understand-Clear-Explaination
 * 
 * Check from left and right at the same time until the first different pair.
 * Now we have something like a****b, where a and b are different.
 * We need to delete either a or b to make it a palindrome.
 */
package com.polyg7ot.lc.lvl3.lc0680;

public class SolutionApproachIteration {
    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                int i1 = i, j1 = j - 1;
                int i2 = i + 1, j2 = j;
                while(i1 < j1 && s.charAt(i1) == s.charAt(j1)){
                    i1++;
                    j1--;
                }
                
                while(i2 < j2 && s.charAt(i2) == s.charAt(j2)){
                    i2++;
                    j2--;
                }
                
                return i1 >= j1 || i2 >= j2;
            }
        }
        
        return true;
    }
}