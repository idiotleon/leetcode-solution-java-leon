/**
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.summaries.traversal.postorder;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class PostorderTraversalRecursive {
    public List<Integer> postorderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;

        postorderTraverse(root, ans);
        return ans;
    }

    private void postorderTraverse(TreeNode node, List<Integer> res){
        if(node == null) return;
        postorderTraverse(node.left, res);
        postorderTraverse(node.right, res);
        res.add(node.val);
    }
}