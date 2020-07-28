/**
 * https://leetcode.com/problems/add-bold-tag-in-string/
 * 
 * Time Complexity:     O((LEN(s) ^ 2) * NUM(dict)) + O(L) ~ O((LEN(s) ^ 2) * NUM(dict))
 * Space Complexity:    O()
 * 
 * References:  
 *  https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array/107108
 *  https://leetcode.com/problems/add-bold-tag-in-string/discuss/104248/Java-Solution-boolean-array
 */
package com.zea7ot.lc.lvl4.lc0616;

public class SolutionApproach0MarkPositions1 {
    private static final String TAG_OPEN = "<b>";
    private static final String TAG_CLOSED = "</b>";

    public String addBoldTag(String s, String[] dict) {
        final int L = s.length();
        boolean[] isBold = new boolean[L];
        for(int i = 0, end = 0; i < L; ++i){
            for(String word : dict){
                if(s.startsWith(word, i)){
                    end = Math.max(end, i + word.length());
                }
            }
            
            isBold[i] = end > i;
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < L; ++i){
            if(!isBold[i]){
                builder.append(s.charAt(i));
            }else{
                int j = i;
                while(j < L && isBold[j]) ++j;
                builder.append(TAG_OPEN).append(s.substring(i, j)).append(TAG_CLOSED);
                i = j - 1;
            }
        }
        
        return builder.toString();
    }
}