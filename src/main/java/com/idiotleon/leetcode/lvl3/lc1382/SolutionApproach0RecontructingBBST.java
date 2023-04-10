/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/balance-a-binary-search-tree/discuss/539686/JavaC%2B%2B-Sorted-Array-to-BST-O(N)-Clean-code
 */
package com.idiotleon.leetcode.lvl3.lc1382;

import java.util.ArrayList;
import java.util.List;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0RecontructingBBST {
    public TreeNode balanceBST(TreeNode root) {
        // sanity check
        if(root == null) return root;
        
        List<TreeNode> sortedNodes = new ArrayList<TreeNode>();
        inorderTraverse(root, sortedNodes);
        
        return dfs(0, sortedNodes.size() - 1, sortedNodes);
    }
    
    private TreeNode dfs(int start, int end, List<TreeNode> sortedNodes){
        if(start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = sortedNodes.get(mid);
        
        root.left = dfs(start, mid - 1, sortedNodes);
        root.right = dfs(mid + 1, end, sortedNodes);
        
        return root;
    }
    
    private void inorderTraverse(TreeNode node, List<TreeNode> list){
        if(node == null) return;
        
        inorderTraverse(node.left, list);
        list.add(node);
        inorderTraverse(node.right, list);
    }
}