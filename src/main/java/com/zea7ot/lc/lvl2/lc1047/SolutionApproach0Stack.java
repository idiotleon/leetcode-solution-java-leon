/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294893/JavaC%2B%2BPython-Two-Pointers-and-Stack-Solution
 */
package com.zea7ot.lc.lvl2.lc1047;

public class SolutionApproach0Stack {
    public String removeDuplicates(String S) {
        StringBuilder builder = new StringBuilder();
        for(char ch : S.toCharArray()){
            final int SIZE = builder.length();
            if(SIZE > 0 && builder.charAt(SIZE - 1) == ch)
                builder.deleteCharAt(SIZE - 1);
            else builder.append(ch);
        }
        
        return builder.toString();
    }
}