/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/222026/Java-Post-order-Traversal-with-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0979;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder2 {
    public int distributeCoins(TreeNode root) {
        if (root == null)
            return 0;
        int[] moves = { 0 };
        postorder(root, moves);
        return moves[0];
    }

    private int postorder(TreeNode node, int[] moves) {
        if (node == null)
            return 0;

        // coin(s) from the children - postorder traversal
        int coin = postorder(node.left, moves) + postorder(node.right, moves);

        // coin(s) of the current node
        if (node.val == 0)
            coin += -1; // current node needs one coin
        else
            coin += node.val - 1; // to leave one coin for the current node

        moves[0] += Math.abs(coin); // to move each coin up to the parent node required 1 move/step
        return coin;
    }
}