/**
 * https://leetcode.com/problems/group-anagrams/
 * 
 * Time Complexity:     O(26 * L * N) ~ O(NL)
 * Space Complexity:    O(N * L)
 */
package com.zea7ot.leetcode.lvl3.lc0049;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0HashMap {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        // sanity check
        if (strs == null || strs.length == 0)
            return ans;

        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String str : strs) {
            int hash = hash(str);
            map.putIfAbsent(hash, new ArrayList<String>());
            map.get(hash).add(str);
        }

        ans.addAll(map.values());
        return ans;
    }

    private int hash(String str) {
        int[] freq = new int[26];
        for (char ch : str.toCharArray()) {
            ++freq[ch - 'a'];
        }

        return Arrays.hashCode(freq);
    }
}