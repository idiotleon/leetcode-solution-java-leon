/**
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 * 
 * Time Complexity:     O(lg(`label`))
 * Space Complexity:    O(1) / O(`initial_depth`)
 * 
 * References:
 *  https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/discuss/327870/java-solution-with-detailed-explanation
 *  https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/discuss/323312/Simple-solution-in-java-(Using-properties-of-complete-binary-tree)-(O-log-N)/298413
 *  https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/discuss/323312/Simple-solution-in-java-(Using-properties-of-complete-binary-tree)-(O-log-N)
 */
package com.idiotleon.leetcode.lvl3.lc1104;

import java.util.LinkedList;
import java.util.List;

public class SolutionApproach0DFS {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> ans = new LinkedList<>();
        int parent = label;
        ans.addFirst(parent);

        while (parent != 1) {
            int depth = (int) (Math.log(parent) / Math.log(2));
            int offset = (int) Math.pow(2, depth + 1) - 1 - parent;
            parent = ((int) Math.pow(2, depth) + offset) / 2;
            ans.addFirst(parent);
        }

        return ans;
    }
}
