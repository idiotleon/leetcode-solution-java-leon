/**
 * https://leetcode.com/problems/bold-words-in-string/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/add-bold-tag-in-string/discuss/104262/short-java-solution
 */
package com.zea7ot.lc.lvl3.lc0758;

public class SolutionApproach0SweepLine {
    private final static String TAG_OPEN = "<b>";
    private final static String TAG_CLOSED = "</b>";
    
    public String boldWords(String[] words, String S) {
        final int L = S.length();
        
        int[] mark = new int[L + 1];
        for(String word : words){
            int idx = 0;
            while((idx = S.indexOf(word, idx)) >= 0){
                ++mark[idx];
                --mark[idx + word.length()];
                idx++;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        int prev = 0, sum = 0;
        for(int i = 0; i <= L; ++i){
            sum += mark[i];
            if(sum > 0 && prev == 0) builder.append(TAG_OPEN);
            if(sum == 0 && prev > 0) builder.append(TAG_CLOSED);
            if(i < L) builder.append(S.charAt(i));
            prev = sum;
        }
        
        return builder.toString();
    }
}