/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *  H, height of the tree
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0889;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0DivideAndConquer {
    private int preIdx = 0, postIdx = 0;
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIdx++]);
        
        if(root.val != post[postIdx]){
            root.left = constructFromPrePost(pre, post);
        }
        
        if(root.val != post[postIdx]){
            root.right = constructFromPrePost(pre, post);
        }
        
        postIdx++;
        return root;
    }
}