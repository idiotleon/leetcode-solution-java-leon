package com.zea7ot.companies.other.construct_narry_tree_from_a_integer_array;

import com.zea7ot.companies.other.construct_narry_tree_from_a_integer_array.SolutionApproach0BFS.NarryTreeNode;

public class DemoApp {
    public static void main(String[] args){
        SolutionApproach0BFS solutionApproach0BFS = new SolutionApproach0BFS();

        final Integer[] nums1 = {1, null, 3, 2, 4, null, 5, 6};

        NarryTreeNode root1 = solutionApproach0BFS.contructNarryTree(nums1);

        final Integer[] nums2 = {1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14};

        NarryTreeNode root2 = solutionApproach0BFS.contructNarryTree(nums2);

        System.out.println("");
    }
}