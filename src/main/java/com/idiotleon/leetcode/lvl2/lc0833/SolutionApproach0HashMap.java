/**
 * https://leetcode.com/problems/find-and-replace-in-string/
 * 
 * Time Complexity:     O(L ^ 2)
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/find-and-replace-in-string/discuss/134758/Java-O(n)-solution
 */
package com.idiotleon.leetcode.lvl2.lc0833;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0HashMap {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        final int N_IDXES = indexes.length;
        final int L = S.length();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N_IDXES; ++i) {
            if (S.startsWith(sources[i], indexes[i])) {
                map.put(indexes[i], i);
            }
        }

        StringBuilder builder = new StringBuilder();
        int idx = 0;
        while (idx < L) {
            if (map.containsKey(idx)) {
                builder.append(targets[map.get(idx)]);
                idx += sources[map.get(idx)].length();
            } else {
                builder.append(S.charAt(idx));
                ++idx;
            }
        }

        return builder.toString();
    }
}
