/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
package com.zea7ot.lc.lvl3.lc0449;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproachBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString(); 
    }
    
    private void serialize(TreeNode root, StringBuilder builder){
        if(root == null) return;
        builder.append(root.val).append(",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(Queue<String> queue, int lower, int upper){
        if(queue.isEmpty()) return null;
        String str = queue.peek();
        int val = Integer.parseInt(str);
        if(val < lower || val > upper) return null;
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue, lower, val);
        root.right = deserialize(queue, val, upper);
        return root;
    }
}