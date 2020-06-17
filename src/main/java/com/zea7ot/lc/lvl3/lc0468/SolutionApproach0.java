/**
 * https://leetcode.com/problems/validate-ip-address/
 */
package com.zea7ot.lc.lvl3.lc0468;

public class SolutionApproach0 {
    public String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.", -1);
        String[] ipv6 = IP.split("\\:", -1);
        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            for(String str : ipv4){
                if(isIPv4(str)) continue;
                else return "Neither";
            }
            
            return "IPv4";
        }
        
        if(IP.chars().filter(ch -> ch == ':').count() == 7){
            for(String str : ipv6) {
                if(isIPv6(str)) continue;
                else return "Neither";
            }
            
            return "IPv6";
        }
        
        return "Neither";
    }
    
    private boolean isIPv4(String str){
        try{
            return String.valueOf(Integer.valueOf(str)).equals(str) 
                && Integer.parseInt(str) >= 0 
                && Integer.parseInt(str) <= 255;
        } 
        catch(NumberFormatException ex){
            return false;
        }
    }
    
    private boolean isIPv6(String str){
        if(str.length() > 4) return false;
        try{
            return Integer.parseInt(str, 16) >= 0 && str.charAt(0) != '-';
        } 
        catch(NumberFormatException ex){
            return false;
        }
    }
}