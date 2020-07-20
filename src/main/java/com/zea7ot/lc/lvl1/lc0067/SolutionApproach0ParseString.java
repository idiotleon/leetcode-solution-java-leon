/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.lc.lvl1.lc0067;

public class SolutionApproach0ParseString {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        final int LEN_A = a.length(), LEN_B = b.length();
        int i = LEN_A - 1, j = LEN_B - 1, carry = 0;
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
        final int LEN_A = a.length(), LEN_B = b.length();
        int idx = 0, carry = 0;
        StringBuilder builder = new StringBuilder();
        while(idx < LEN_A || idx < LEN_B || carry != 0){
            int x = (idx < LEN_A) ? a.charAt(LEN_A - 1 - idx) - '0' : 0;
            int y = (idx < LEN_B) ? b.charAt(LEN_B - 1 - idx) - '0' : 0;
            int sum = x + y + carry;
            builder.append(sum % 2);
            carry = sum / 2;
            idx++;
        }
        
        return builder.reverse().toString();
    }
}