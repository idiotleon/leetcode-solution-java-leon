/**
 * https://leetcode.com/problems/group-shifted-strings/
 * 
 * Time Complexity:     O(N * L)
 * Space Complexity:    O(N * L)
 * 
 * References:
 *  https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution/69322
 */
package com.zea7ot.leetcode.lvl4.lc0249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0LinearScan {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if (strings == null || strings.length == 0)
            return ans;

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strings) {
            String key = hash(str);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet())
            ans.add(entry.getValue());

        return ans;
    }

    private String hash(String str) {
        final int L = str.length();
        char[] chs = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < L; i++) {
            // to simulate shift
            int diff = (int) (chs[i] - chs[0]);
            // alphabet letters in a circle
            if (diff < 0)
                diff += 26;
            builder.append(",").append(diff);
        }

        return builder.toString();
    }
}