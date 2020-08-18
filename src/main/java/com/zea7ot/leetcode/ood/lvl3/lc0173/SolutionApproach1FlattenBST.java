/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Time Complexity:     
 *  construction:   O(N)
 *  next()          O(1)
 *  hasNext()       O(1)
 * 
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.ood.lvl3.lc0173;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1FlattenBST{
    private List<Integer> nodesSorted;
    private int index;

    public SolutionApproach1FlattenBST(TreeNode root) {
        this.nodesSorted = new ArrayList<Integer>();
        this.index = -1;
        this.inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        
        this.inorder(root.left);
        this.nodesSorted.add(root.val);
        this.inorder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}