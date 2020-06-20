/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * to top-down DFS
 */
package com.zea7ot.lc.lvl3.lc0105;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0DFS1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // sanity check
        if(inorder == null 
            || inorder.length == 0 
            || preorder == null 
            || preorder.length == 0 
            || inorder.length != preorder.length)
                return null;

        final int L = preorder.length;
        Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < L; i++){
            idxMap.put(inorder[i], i);
        }
        int[] preIdx = new int[]{0};
        
        return dfs(idxMap, preorder, preIdx, 0, L);
    }
    
    private TreeNode dfs(Map<Integer, Integer> idxMap, 
                         int[] preorder, 
                         int[] preIdx,
                         int inorderStart, 
                         int inorderRight){
        if(inorderStart == inorderRight) return null;
        
        int rootVal = preorder[preIdx[0]];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        
        preIdx[0]++;
        root.left = dfs(idxMap, preorder, preIdx, inorderStart, index);
        root.right = dfs(idxMap, preorder, preIdx, index + 1, inorderRight);
        
        return root;
    }
}