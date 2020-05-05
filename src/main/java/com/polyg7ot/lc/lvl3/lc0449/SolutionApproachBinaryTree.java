/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
package com.polyg7ot.lc.lvl3.lc0449;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder builder){
        if(root == null)
            builder.append("#").append(",");
        else{
            builder.append(root.val).append(",");
            serialize(root.left, builder);
            serialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue){
        String str = queue.poll();
        if(str.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}