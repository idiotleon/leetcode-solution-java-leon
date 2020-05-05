/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
package com.polyg7ot.lc.lvl2.lc1071;

public class SolutionApproachKMP {
    public String gcdOfStrings(String str1, String str2) {
        if(str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) return "";
        
        String seg1 = getRepeatedSegment(str1), seg2 = getRepeatedSegment(str2);
        if(!seg1.equals(seg2) || seg1 == "") return "";
        
        // to calculate the greatest common divisor
        int a = str1.length() / seg1.length();
        int b = str2.length() / seg2.length();
        
        while(a * b != 0){
            if(a < b) {
                int temp = a;
                a = b;
                b = temp;
            }
            a = a % b;
        }
        
        // to compose the answer
        String ans = "";
        for(int i = 0; i < b; i++){
            ans += seg1;
        }
        return ans;
    }
    
    // to get the shortest repeated segment if possible
    private String getRepeatedSegment(String str){
        if(str == null || str.isEmpty()) return str;
        
        final int L = str.length();
        int[] kmpTable = new int[L];
        
        int i = 1, j = 0;
        while(i < L){
            if(str.charAt(i) == str.charAt(j)){
                kmpTable[i++] = ++j;
            }else if(j == 0){
                i++;
            }else{
                j = kmpTable[j - 1];
            }
        }
        
        if((j > 0) && (L % (L - j) == 0)){
            return str.substring(0, L - j);
        }
        
        return str;
    }
}