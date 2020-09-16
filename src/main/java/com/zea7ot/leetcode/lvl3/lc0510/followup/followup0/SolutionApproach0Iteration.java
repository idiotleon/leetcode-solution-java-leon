/**
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents/281258
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/239399/JAVA-iterative-Beats-100-4ms-not-looking-up-node-values.-Detailed-explanation.
 */
package com.zea7ot.leetcode.lvl3.lc0510.followup.followup0;

public class SolutionApproach0Iteration {
    public Node inorderSuccessor(Node node) {
        if (node.right == null) {
            Node cur = node;
            while (cur.parent != null && cur.parent.right == cur) {
                cur = cur.parent;
            }

            return cur.parent;
        }

        Node cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }

        return cur;
    }
}
