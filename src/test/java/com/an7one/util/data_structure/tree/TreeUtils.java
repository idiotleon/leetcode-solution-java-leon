package com.an7one.util.data_structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {

    /**
     * to serialize the following tree, each node with a pointer to its parent:
     *       1
     *      / \
     *     2   3
     *        / \
     *       4   5
     * 
     * as "[1,2,3,null,null,4,5]"
     * 
     */
    public TreeNodeWithParentPointer buildTreeWithParentPointer(Integer[] nums){
        // sanity check
        if(nums == null || nums.length == 0) return null;

        final int N = nums.length;
        TreeNodeWithParentPointer root = new TreeNodeWithParentPointer(nums[0]);
        int idx = 1;

        Queue<TreeNodeWithParentPointer> queue = new LinkedList<TreeNodeWithParentPointer>();
        queue.offer(root);

        while(!queue.isEmpty()){
            final int SIZE = queue.size();

            for(int i = 0; i < SIZE; i++){
                TreeNodeWithParentPointer top = queue.poll();

                if(idx < N && nums[idx] != null){
                    TreeNodeWithParentPointer left = new TreeNodeWithParentPointer(nums[idx]);
                    top.left = left;
                    left.parent = top;
                    queue.offer(left);
                    idx++;
                }

                if(idx < N && nums[idx] != null){
                    TreeNodeWithParentPointer right = new TreeNodeWithParentPointer(nums[idx]);
                    top.right = right;
                    right.parent = top;
                    queue.offer(right);
                    idx++;
                }
            }
        }

        return root;
    }
}