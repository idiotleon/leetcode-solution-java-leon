package com.an7one.bycompany.others.tree.traverse_binary_tree_with_parent_pointer;

import com.an7one.util.data_structure.tree.TreeNodeWithParentPointer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.an7one.util.data_structure.tree.Constants;
import com.an7one.util.data_structure.tree.TreeUtils;

import org.junit.jupiter.api.Test;

public class TestSolution {
    private TreeUtils treeUtils = new TreeUtils();
    private Solution solution = new Solution();

    private TreeNodeWithParentPointer root;

    @Test
    void test1(){
        root = treeUtils.buildTreeWithParentPointer(Constants.nums1);
        assertEquals(Constants.nums1Inorder, solution.inorderTraverse(root)); 
    }

    @Test
    void test2(){
        root = treeUtils.buildTreeWithParentPointer(Constants.nums2);
        assertEquals(Constants.nums2Inorder, solution.inorderTraverse(root)); 
    }
}