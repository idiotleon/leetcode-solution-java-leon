/**
 * 
 * References:
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
 */
package com.zea7ot.algorithm.summaries.traversal.inorder;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class MorrisInorderTraversal {
    public List<Integer> inorderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        TreeNode cur = root;
        while(cur != null){
            // if `left` is null, to visit the node and go to right
            if(cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else{
                // to find the inorder predecessor
                // to keep going right till right node is not null or right node is node current
                TreeNode predecessor = cur.left;
                while(predecessor.right != cur && predecessor.right != null){
                    predecessor = predecessor.right;
                }

                // if the `right` is null, 
                // to go left after establishing link from `predecessor` to `cur`
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }else{ // if `left` is already visited,  to go right visiting `cur`
                    predecessor.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return ans;
    }
}