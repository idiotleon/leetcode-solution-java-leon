/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/414172/PythonC++Java-Set-Solution/374058
 *  https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/discuss/414172/PythonC%2B%2BJava-Set-Solution
 */
package com.zea7ot.leetcode.lvl3.lc1239;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack1 {
    public int maxLength(List<String> arr) {
        List<String> ans = new ArrayList<>();
        ans.add("");

        for (String str : arr) {
            if (!isUnique(str))
                continue;

            List<String> res = new ArrayList<>();
            for (String candidate : ans) {
                String newStr = candidate + str;
                if (isUnique(newStr))
                    res.add(newStr);
            }

            ans.addAll(res);
        }

        int longest = 0;
        for (String str : ans)
            longest = Math.max(longest, str.length());

        return longest;
    }

    private boolean isUnique(String str) {
        final int L = str.length();
        if (L > 26)
            return false;

        int[] used = new int[26];
        for (final char CH : str.toCharArray()) {
            if (used[CH - 'a']++ > 0)
                return false;
        }

        return true;
    }
}
