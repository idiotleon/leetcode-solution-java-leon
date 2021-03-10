/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/find-duplicate-file-in-system/discuss/104134/Java-Solution-HashMap
 */
package com.an7one.leetcode.lvl3.lc0609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionApproach0HashMap {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        // sanity check
        if (paths == null || paths.length == 0)
            return ans;

        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split("\\s+");
            final int N_S = strs.length;
            for (int i = 1; i < N_S; ++i) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String filename = strs[0] + "/" + strs[i].substring(0, idx);
                Set<String> filenames = map.getOrDefault(content, new HashSet<>());
                filenames.add(filename);
                map.put(content, filenames);
            }
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                ans.add(new ArrayList<>(entry.getValue()));
            }
        }

        return ans;
    }
}