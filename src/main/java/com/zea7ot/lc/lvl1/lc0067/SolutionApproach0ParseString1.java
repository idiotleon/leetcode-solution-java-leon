/**
 * https://leetcode.com/problems/add-binary/
 * 
 * Time Complexity:     O(L)
 * Space Complexity:    O(L)
 */
package com.zea7ot.lc.lvl1.lc0067;

public class SolutionApproach0ParseString1 {
    public String addBinary(String a, String b) {
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