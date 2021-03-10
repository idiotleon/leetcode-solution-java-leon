/**
 * to traverse the given Binary Tree, whose TreeNode contains a parent pointer, in O(1) space
 * 
 * NOT YET completed
 */
package com.an7one.bycompany.others.tree.traverse_binary_tree_with_parent_pointer;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNodeWithParentPointer;

public class Solution {
    public List<Integer> inorderTraverse(TreeNodeWithParentPointer root){
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        TreeNodeWithParentPointer cur = root;
        while(cur != null){
            while(cur.left != null){
                cur = cur.left;
            }

            ans.add(cur.val);
            cur = cur.parent;
            cur = cur.right;
        }

        return ans;
    }
}