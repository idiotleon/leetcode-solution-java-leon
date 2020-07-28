/**
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * 
 * Time Complexity:     O(LEN(s) * NUM(dict)) + O(LEN(s)) ~ 
 * Space Complexity:    O()
 * 
 * References:
 *   https://leetcode.com/problems/add-bold-tag-in-string/discuss/104262/short-java-solution
 */
package com.zea7ot.lc.lvl4.lc0616;

public class SolutionApproach0SweepLine {
    private static final String TAG_OPEN = "<b>";
    private static final String TAG_CLOSED = "</b>";

    public String addBoldTag(String s, String[] dict) {
        final int L = s.length();
        int[] mark = new int[L + 1];
        for(String word : dict){
            int i = -1;
            while((i = s.indexOf(word, i + 1)) >= 0){
                ++mark[i];
                --mark[i + word.length()];
            }
        }
        
        StringBuilder builder = new StringBuilder();
        int sum = 0;
        for(int i = 0; i <= L; ++i){
            int cur = sum + mark[i];
            if(cur > 0 && sum == 0) builder.append(TAG_OPEN);
            if(cur == 0 && sum > 0) builder.append(TAG_CLOSED);
            if(i == L) break;
            builder.append(s.charAt(i));
            sum = cur;
        }
        
        return builder.toString();
    }
}