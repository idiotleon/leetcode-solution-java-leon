/**
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 * 
 * There are only two cases: 
 *  Case 1 the node has no right node, so successor might be in the parent.
 *      Just to loop through the parent and find the first one bigger than `node`
 *  Case 2 is where the `node` has a right child. 
 *      It doesn't matter if the parent node exist of not. Just to find the successor.
 * 
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents/279202
 *  https://leetcode.com/problems/delete-node-in-a-bst/solution/
 */
package com.zea7ot.leetcode.lvl3.lc0510;

public class SolutionApproach0Iteration {
    public Node inorderSuccessor(Node node) {
        if (node.right == null) {
            Node cur = node.parent;
            while (cur != null && cur.val < node.val) {
                cur = cur.parent;
            }
            return cur;
        } else {
            Node cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
    }
}