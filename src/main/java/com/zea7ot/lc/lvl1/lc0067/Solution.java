/**
 * https://leetcode.com/problems/add-binary/
 */
package com.zea7ot.lc.lvl1.lc0067;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(j >= 0) sum += b.charAt(j--) - '0';
            if(i >= 0) sum += a.charAt(i--) - '0';
            builder.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0) builder.append(carry);
        return builder.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        int lena = a.length(), lenb = b.length();
        int i = 0, carry = 0;
        String res = "";
        while(i < lena || i < lenb || carry != 0){
            int x = (i < lena) ? a.charAt(lena - 1 - i) - '0' : 0;
            int y = (i < lenb) ? b.charAt(lenb - 1 - i) - '0' : 0;
            int sum = x + y + carry;
            res = sum % 2 + res;
            carry = sum / 2;
            i++;
        }
        
        return res;
    }
}