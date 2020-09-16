/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N * L)
 *  N, the amount of numbers
 *  L, the average bit length of numbers
 */
package com.zea7ot.leetcode.lvl4.lc0421;

public class SolutionApproach0Trie {
    public int findMaximumXOR(int[] nums) {
        // sanity check
        if (nums == null || nums.length == 0)
            return 0;

        TrieNode root = new TrieNode();
        int max = 0;

        for (int num : nums) {
            TrieNode node = root;
            TrieNode complement = root;

            int sum = 0;

            for (int i = 31; i >= 0; --i) {
                // to get the i-th bit
                int bit = (num >>> i) & 1;

                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];

                if (complement.children[1 ^ bit] != null) { // equivalently: 1 - bit, 1 ^ bit
                    complement = complement.children[1 ^ bit]; // equivalently: 1 - bit, 1 ^ bit
                    // if it exists, to add that bit
                    sum += (1 << i);
                } else {
                    complement = complement.children[bit];
                }
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private class TrieNode {
        private final TrieNode[] children;

        private TrieNode() {
            this.children = new TrieNode[2];
        }
    }
}