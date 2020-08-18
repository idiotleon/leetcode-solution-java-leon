/**
 * https://leetcode.com/problems/count-and-say/
 */
package com.zea7ot.leetcode.lvl2.lc0038;

public class Solution{
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++){
            res = countIdx(res);
        }
        
        return res;
    }
    
    private String countIdx(String str){
        StringBuilder builder = new StringBuilder();
        char c = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == c) count++;
            else{
                builder.append(count);
                builder.append(c);
                c = str.charAt(i);
                count = 1;
            }
        }
        
        builder.append(count);
        builder.append(c);
        
        return builder.toString();
    }
}