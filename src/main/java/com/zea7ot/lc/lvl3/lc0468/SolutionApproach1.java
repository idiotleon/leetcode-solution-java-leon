/**
 * https://leetcode.com/problems/validate-ip-address/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/validate-ip-address/discuss/134965/java-easy-to-remember-and-impl-in-10mins.-good-luck-all
 */
package com.zea7ot.lc.lvl3.lc0468;

public class SolutionApproach1 {
    public String validIPAddress(String IP) {
        if(isIPv4(IP)) return "IPv4";
        
        if(isIPv6(IP.toUpperCase())) return "IPv6";
        
        return "Neither";
    }
    
    private boolean isIPv4(String IP){
        // to count dots
        int cnt = 0;
        for(char ch : IP.toCharArray()){
            if(ch == '.') cnt++;
        }
        
        if(cnt != 3) return false;
        
        String[] fields = IP.split("\\.");
        if(fields.length != 4) return false;
        
        for(String field : fields){
            if(field.isEmpty() || field.length() > 3) return false;
            
            final int L = field.length();
            for(int i = 0; i < L; i++){
                if(!Character.isDigit(field.charAt(i))) 
                    return false;
            }
            
            int num = Integer.valueOf(field);
            if(!String.valueOf(num).equals(field) || num < 0 || num > 255) return false;
        }
        
        return true;
    }
    
    private boolean isIPv6(String IP){
        int count = 0;
        for(char ch : IP.toCharArray()){
            if(ch == ':') count++;
        }
        
        if(count != 7) return false;
        
        String[] fields = IP.split(":");
        if(fields.length != 8) return false;
        
        for(String field : fields){
            if(field.isEmpty() || field.length() > 4) return false;
            
            final int L = field.length();
            for(int i = 0; i < L; ++i){
                if(!Character.isDigit(field.charAt(i)) 
                   && (field.charAt(i) < 'A' || field.charAt(i) > 'F'))
                    return false;
            }
        }
        
        return true;
    }
}