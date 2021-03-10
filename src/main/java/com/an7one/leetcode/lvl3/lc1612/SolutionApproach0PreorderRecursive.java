/**
 * https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/discuss/886523/Java-Preorder-or-O(n)-time-O(26)-spaceor-Followup-solution
 */
package com.an7one.leetcode.lvl3.lc1612;

public class SolutionApproach0PreorderRecursive {
    public boolean checkEquivalence(Node root1, Node root2) {
        final int[] FREQS = new int[26];
        preorder(root1, FREQS, 1);
        preorder(root2, FREQS, -1);

        for (int freq : FREQS) {
            if (freq != 0)
                return false;
        }

        return true;
    }

    private void preorder(Node node, final int[] FREQS, final int FLAG) {
        if (node == null)
            return;

        final char CH = node.val;

        if (CH >= 'a' && CH <= 'z') {
            FREQS[CH - 'a'] += 1 * FLAG;
        }

        preorder(node.left, FREQS, FLAG);
        preorder(node.right, FREQS, FLAG);
    }
}
