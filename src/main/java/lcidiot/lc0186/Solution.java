/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 */
package main.java.lcidiot.lc0186;

class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);
    }
    
    private void reverseEachWord(char[] chars){
        final int N = chars.length;
        int start = 0, end = 0;
        
        while(start < N){
            while(end < N && chars[end] != ' ') ++end;
            reverse(chars, start, end - 1);
            start = end + 1;
            ++end;
        }
    }
    
    private void reverse(char[] chars, int left, int right){
        while(left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}