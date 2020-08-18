/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * Time Complexity:     O(L ^ 4)
 * Space Complexity:    O(L)
 */
package com.zea7ot.leetcode.lvl3.lc0093;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0ParsingString {
    public List<String> restoreIpAddresses(String str) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if (str == null || str.isEmpty())
            return ans;
        final int L = str.length();

        for (int i = 1; i < 4 && i < L - 2; ++i) {
            for (int j = i + 1; j < i + 4 && j < L - 1; ++j) {
                for (int k = j + 1; k < j + 4 && k < L; ++k) {
                    String str1 = str.substring(0, i);
                    String str2 = str.substring(i, j);
                    String str3 = str.substring(j, k);
                    String str4 = str.substring(k, L);

                    if (isValid(str1) && isValid(str2) && isValid(str3) && isValid(str4)) {
                        ans.add(str1 + "." + str2 + "." + str3 + "." + str4);
                    }
                }
            }
        }

        return ans;
    }

    private boolean isValid(String str) {
        final int L = str.length();
        if (L > 3 || L == 0 || (str.charAt(0) == '0' && L > 1) || Integer.parseInt(str) > 255)
            return false;

        return true;
    }
}