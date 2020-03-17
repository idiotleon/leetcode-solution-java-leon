/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
package main.java.lcidiot.lc0093;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        int len = s.length();
        
        for(int i = 1; i < 4 && i < len - 2; i++)
            for(int j = i + 1; j < i + 4 && j < len - 1; j++)
                for(int k = j + 1; k < j + 4 && k < len; k++){
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
        
        return ans;
    }
    
    private boolean isValid(String str){
        if(str.length() > 3 || str.length() == 0 
           || (str.charAt(0) == '0' && str.length() > 1) 
           || Integer.parseInt(str) > 255) 
            return false;
        
        return true;
    }
}