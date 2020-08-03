/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(NUM("\n"))
 * 
 * References:
 *  https://leetcode.com/problems/longest-absolute-file-path/discuss/86615/9-lines-4ms-Java-solution
 */
package com.zea7ot.lc.lvl3.lc0388;

public class SolutionApproach0ParsingString {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        final int N = strs.length;
        int[] stack = new int[N + 1];
        
        int maxLen = 0;
        for(String str : strs){
            final int L = str.length();
            int idx = str.lastIndexOf("\t") + 1;
            int curLen = stack[idx + 1] = stack[idx] + L - idx + 1;
            
            if(str.contains("."))
                maxLen = Math.max(maxLen, curLen - 1);
        }
        
        return maxLen;
    }
}