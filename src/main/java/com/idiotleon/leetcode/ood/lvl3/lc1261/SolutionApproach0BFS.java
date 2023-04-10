/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 * 
 * 
 * Time Complexities:
 *  Initialization:     O(N)
 *  find():             O(1)
 * 
 * Space Complexity:    O(H) + O(N)
 * 
 * References:  
 *  https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-clean-code-w-analysis./390121
 */
package com.idiotleon.leetcode.ood.lvl3.lc1261;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    private final Set<Integer> SEEN;

    public SolutionApproach0BFS(TreeNode root) {
        this.SEEN = new HashSet<>();
        bfs(root);
    }

    public boolean find(int target) {
        return SEEN.contains(target);
    }

    private void bfs(TreeNode root) {
        root.val = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int SIZE = queue.size();

            for (int i = 0; i < SIZE; ++i) {
                TreeNode cur = queue.poll();
                final int VAL = cur.val;
                SEEN.add(VAL);

                if (cur.left != null) {
                    cur.left.val = VAL * 2 + 1;
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    cur.right.val = VAL * 2 + 2;
                    queue.offer(cur.right);
                }
            }
        }
    }
}
