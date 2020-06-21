/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
 * 
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 * 
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation: 
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
 * Other valid sequences are: 
 * 0 -> 1 -> 1 -> 0 
 * 0 -> 0 -> 0
 * 
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false 
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * 
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 */
package com.zea7ot.lc.explore.challenge30days.valid_sequence_from_root_to_leaves;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null || arr == null || root.val != arr[0]) return false;
                
        if(isValidSequence(root, arr, 0)) return true;
        
        return false;
    }
    
    private boolean isValidSequence(TreeNode node, int[] arr, int idx){
        if(node == null)  return false;
        if(node.val != arr[idx]) return false;    
        
        if(idx == arr.length - 1){
            // to decide whether it is a leaf
            if(node.left == null && node.right == null) return true;
            return false;
        }
                
        if(node.val == arr[idx]){
            return isValidSequence(node.left, arr, idx + 1) 
                    || isValidSequence(node.right, arr, idx + 1);
        }
        
        return false;
    }
}