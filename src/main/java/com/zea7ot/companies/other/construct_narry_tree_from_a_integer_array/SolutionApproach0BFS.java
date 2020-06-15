/**
 * Time Complexity:     O(N)
 *  O(N), total number of N-arry tree nodes
 * 
 * Space Complexity:    O(W) + O(N)
 *  O(W), the maximum width of this N-arry tree
 *  O(N), consumed by the answer N-arry tree
 */
package com.zea7ot.companies.other.construct_narry_tree_from_a_integer_array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    public NarryTreeNode contructNarryTree(Integer[] nums){
        // sanity check
        if(nums == null || nums.length == 0 || nums[0] == null) return null;

        final int N = nums.length;
        Queue<NarryTreeNode> queue = new LinkedList<NarryTreeNode>();
        // to initialize idx with the first element, which might be "null",
        // of the first level, considering "root" level as level 0.
        int idx = 0;
        while(nums[idx] != null) idx++;
        idx++;

        NarryTreeNode root = new NarryTreeNode(nums[idx]);
        queue.offer(root);

        while(!queue.isEmpty()){
            final int SIZE = queue.size();

            for(int i = 0; i < SIZE; i++){
                NarryTreeNode parent = queue.poll();

                while(idx < N && nums[idx] != null ){
                    NarryTreeNode child = new NarryTreeNode(nums[idx]);
                    parent.addChild(child);
                    queue.add(child);
                    idx++;
                }
            
                idx++;
            }
        }

        return root;
    }

    protected class NarryTreeNode{
        @SuppressWarnings("unused")
        protected int val;
        protected List<NarryTreeNode> children;

        protected NarryTreeNode(int val){
            this.val = val;
            this.children = new ArrayList<NarryTreeNode>();
        }

        protected void addChild(NarryTreeNode child){
            this.children.add(child);
        }

        @SuppressWarnings("unused")
        protected void addChild(int val){
            this.children.add(new NarryTreeNode(val));
        }
    }
}