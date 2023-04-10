/**
 * @author: Leon
 * 
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * 
 * Time Complexity:     O(L)
 * Space Complexity;    O(1)/O(L)
 * 
 * References:
 *  https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
package com.idiotleon.leetcode.lvl1.lc0345;

import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0TwoPointers {
    public String reverseVowels(String str) {
        // sanity check
        if(str == null || str.isEmpty()) return str;
        
        @SuppressWarnings("SERIAL")
        final Set<Character> VOWELS = new HashSet<Character>(){
            /**
            * to remove the warning of lack of "serialVersionUID"
            */
            private static final long serialVersionUID = -1385075954219052941L;

            {
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};
        
        final int L = str.length();
        char[] chs = str.toCharArray();
        int lo = 0, hi = L - 1;
        
        while(lo < hi){
            while(lo < hi && !VOWELS.contains(chs[lo]))
                ++lo;
            
            while(lo < hi && !VOWELS.contains(chs[hi]))
                --hi;
            
            swap(lo++, hi--, chs);
        }
        
        return String.valueOf(chs);
    }
    
    private void swap(int lo, int hi, char[] chs){
        char temp = chs[lo];
        chs[lo] = chs[hi];
        chs[hi] = temp;
    }
}