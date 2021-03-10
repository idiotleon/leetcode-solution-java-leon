/**
 * Given two arrays: `nums`(1 dimensional), and `pieces`(2 dimensional), can
 * `nums` be coined with arrays of `pieces`?
 * 
 * e.g. 1: nums: [1,3,5,3] pieces: [[1],[3,5],[3]] expected: true
 * 
 * e.g. 2: nums: [1,3,5,3] pieces: [[1],[5,3],[3]] expected: false
 */
package com.an7one.bycompany.others.array.coin_the_array;

// import java.util.HashMap;
// import java.util.Map;

// public class SolutionApproach0DFSWithTrie {
// public boolean canCoin(int[] nums, int[][] pieces) {
// // sanity check
// if (nums == null || nums.length == 0)
// return false;

// final int N = nums.length;

// TrieNode root = buildTrie(pieces);
// return dfs(0, nums, root);
// }

// private boolean dfs(int idx, int[] nums, TrieNode node) {
// final int N = nums.length;
// if (idx == N && node.piece != null)
// return true;

// }

// private TrieNode buildTrie(int[][] pieces) {
// TrieNode root = new TrieNode(Integer.MIN_VALUE);

// TrieNode cur = root;
// for (int[] piece : pieces) {
// for (int child : piece) {
// TrieNode newNode = new TrieNode(child);
// cur.children.putIfAbsent(child, newNode);
// cur = newNode;
// }

// cur.piece = piece;
// }

// return root;
// }

// private class TrieNode {
// protected int val;
// protected int[] piece;
// protected final Map<Integer, TrieNode> children;

// protected TrieNode(int val) {
// this.val = val;
// this.piece = null;
// this.children = new HashMap<>();
// }
// }
// }