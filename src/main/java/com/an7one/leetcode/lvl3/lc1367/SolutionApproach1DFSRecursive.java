/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 * 
 * Time Complexity:     O(L * min(H, N))
 *  L, the length of the linked list
 *  H, the height of the tree
 *  N, the total amount of tree nodes
 * 
 * Space Complexity:    ?O()
 * 
 * References:
 *  https://leetcode.com/problems/linked-list-in-binary-tree/discuss/535370/Java-KMP-Search-O(m%2Bn)-Clean-code
 *  https://leetcode.com/problems/linked-list-in-binary-tree/discuss/524881/Python-Recursive-Solution-O(N)-Time
 */
package com.an7one.leetcode.lvl3.lc1367;

import com.an7one.util.data_structure.linkedlist.ListNode;
import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach1DFSRecursive {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null)
            return true;
        if (root == null)
            return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}