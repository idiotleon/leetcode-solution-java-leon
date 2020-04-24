/**
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc.lvl2.lc0409;

public class SolutionApproachMath {
    public int longestPalindrome(String str) {
        if(str == null || str.length() == 0) return 0;
        
        int[] counts = new int[256];
        for(int i = 0; i < str.length(); i++){
            counts[str.charAt(i)]++;
        }
        
        int odd = 0;
        for(int count : counts){
            if(count % 2 != 0){
                odd++;
            }
        }
        
        return odd == 0 ? str.length() : str.length() - odd + 1;
    }
}