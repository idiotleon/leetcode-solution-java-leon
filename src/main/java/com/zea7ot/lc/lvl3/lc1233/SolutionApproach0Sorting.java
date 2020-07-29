/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 * 
 * Time Complexity:     O(N * L * lg(N))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/discuss/409028/JavaPython-3-3-methods-from-O(n-*-(logn-%2B-m-2))-to-O(n-*-m)-w-brief-explanation-and-analysis.
 */
package com.zea7ot.lc.lvl3.lc1233;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0Sorting {
    public List<String> removeSubfolders(String[] folders) {
        LinkedList<String> ans = new LinkedList<String>();
        Arrays.sort(folders);
        for (String folder : folders) {
            if (ans.isEmpty() || !folder.startsWith(ans.peekLast() + '/'))
                ans.offer(folder);
        }

        return ans;
    }
}