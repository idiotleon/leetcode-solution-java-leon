/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space/154363
 */
package com.zea7ot.lc.lvl3.lc0106;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // sanity check
        if(inorder == null 
            || inorder.length == 0 
            || postorder == null 
            || postorder.length == 0 
            || inorder.length != postorder.length) 
                return null;
        final int L = postorder.length;
        return dfs(inorder, postorder, L - 1, 0, L - 1);
    }
    
    private TreeNode dfs(int[] inorder, 
                         int[] postorder, 
                         int idxPostorder, 
                         int inorderStart, 
                         int inorderEnd){
        if(idxPostorder < 0 || inorderStart > inorderEnd) return null;
        
        final int L = postorder.length;
        int rootVal = postorder[idxPostorder];
        TreeNode root = new TreeNode(rootVal);
        int idxInorder = 0;
        while(idxInorder < L){
            if(inorder[idxInorder] == rootVal) break;
            idxInorder++;
        }
        
        root.right = dfs(inorder, postorder, idxPostorder - 1, idxInorder + 1, inorderEnd);
        root.left = dfs(inorder, postorder, idxPostorder - (inorderEnd - idxInorder + 1), inorderStart, idxInorder - 1);
        return root;
    }
}