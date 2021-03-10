/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 * 
 * Time Complexity:     O(N * (lg(N) + L ^ 2))
 *  L, average length of the strings in folders
 * 
 * Space Complexity:    O(N * L)
 *  L, average length of the strings in folders
 * 
 * References:
 *  https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/discuss/409028/JavaPython-3-3-methods-from-O(n-*-(logn-%2B-m-2))-to-O(n-*-m)-w-brief-explanation-and-analysis.
 */
package com.an7one.leetcode.lvl3.lc1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0Sorting1 {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders, Comparator.comparing(folder -> folder.length()));
        Set<String> seen = new HashSet<String>();
        outer: for (String folder : folders) {
            for (int i = 2; i < folder.length(); ++i) {
                if (folder.charAt(i) == '/' && seen.contains(folder.substring(0, i)))
                    continue outer;
            }

            seen.add(folder);
        }

        return new ArrayList<>(seen);
    }
}