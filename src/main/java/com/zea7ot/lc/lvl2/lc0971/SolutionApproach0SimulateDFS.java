/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/discuss/214384/JavaC%2B%2BPython-Iterative-Solution-Using-Stack
 */
package com.zea7ot.lc.lvl2.lc0971;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0SimulateDFS {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> path = new ArrayList<Integer>();
        int idx = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            if(node.val != voyage[idx++]) return Arrays.asList(-1);
            if(node.right != null && node.right.val == voyage[idx]){
                if(node.left != null) path.add(node.val);
                stack.push(node.left);
                stack.push(node.right);
            }else{
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        
        return path;
    }
}