/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 
 * Time Complexity: O(2 * N) ~ O(N)
 * Space Complexity: O(N * L)
 *  N, the length of nums(int[])
 *  L, the average bit length of each num (in the nums)
 */
package com.zea7ot.lc.lvl4.lc0421;

public class SolutionApproach1Trie {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        TrieNode root = buildTrie(nums);
        
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            TrieNode node = root;
            int sum = 0;
            for(int i = 31; i >= 0; i--){
                // to get the i-th bit
                int curBit = (num >>> i) & 1;
                // to search in the Trie tree based on XOR results
                // if curBit is 0, to go to node.children[1]
                // if curBit is 1, to go to node.children[0]
                if(node.children[curBit ^ 1] != null){
                    sum += (1 << i);
                    node = node.children[curBit ^ 1];
                }else{
                    node = node.children[curBit];
                }
            }
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    /**
     * to build up the Trie tree
     * 
     * @param nums
     * @return
     */
    private TrieNode buildTrie(int[] nums){
        TrieNode root = new TrieNode();
        for(int num : nums){
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                // to get the i-th bit
                int curBit = (num >>> i) & 1;
                
                if(node.children[curBit] == null){
                    node.children[curBit] = new TrieNode();
                }
                
                node = node.children[curBit];
            }
        }
        
        return root;
    }

    class TrieNode{
        public final TrieNode[] children;
        
        public TrieNode(){
            children = new TrieNode[2];
        }
    }
}
