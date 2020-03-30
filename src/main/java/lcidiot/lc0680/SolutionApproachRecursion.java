/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package main.java.lcidiot.lc0680;

class SolutionApproachRecursion {
    public boolean validPalindrome(String s) {
        int left = -1, right = s.length();
        while(++left < --right){
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s, left, right + 1) 
                    || isPalindrome(s, left - 1, right);
            }
        }
        
        return true;
    }
    
    private boolean isPalindrome(String str, int left, int right){
        while(++left < --right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
        }
        
        return true;
    }
}