/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 * 
 * Time Complexity:     O(L + N) ~ O(max(L, N))
 *  L, amount of nodes of the linked list
 *  N, amount of nodes of the tree
 * 
 * Space Complexity:    O(H + L) ~ O(max(H, L))
 *  H, height of the tree
 *  L, amount of nodes of the linked list
 * 
 * References:
 *  https://leetcode.com/problems/linked-list-in-binary-tree/discuss/535370/Java-KMP-Search-O(m%2Bn)-Clean-code
 */
package com.zea7ot.leetcode.lvl3.lc1367;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;
import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0KMPAlgorithm {
    public boolean isSubPath(ListNode head, TreeNode root) {
        int[] pattern = toArray(head);
        final int[] KMP = getKMPTable(pattern);
        return kmpSearch(root, 0, KMP, pattern);
    }

    private boolean kmpSearch(TreeNode node, int idx, final int[] KMP, int[] pattern) {
        final int N = pattern.length;
        if (idx == N)
            return true;
        if (node == null)
            return false;
        while (idx > 0 && node.val != pattern[idx])
            idx = KMP[idx - 1];
        if (node.val == pattern[idx])
            ++idx;
        return kmpSearch(node.left, idx, KMP, pattern) || kmpSearch(node.right, idx, KMP, pattern);
    }

    private int[] getKMPTable(int[] pattern) {
        final int N = pattern.length;
        final int[] KMP = new int[N];
        for (int i = 1, j = 0; i < N; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = KMP[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                KMP[i] = ++j;
            }
        }

        return KMP;
    }

    private int[] toArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}