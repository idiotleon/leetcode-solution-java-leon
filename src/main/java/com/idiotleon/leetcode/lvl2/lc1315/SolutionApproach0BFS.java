/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(W)
 *  W, the maximum width of the tree
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/482991/Easy-BFS-solution-in-Java
 */
package com.idiotleon.leetcode.lvl2.lc1315;

import java.util.LinkedList;
import java.util.Queue;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(node.left != null){
                queue.add(node.left);
                if(node.val % 2 == 0){
                    if(node.left.left != null) sum += node.left.left.val;
                    if(node.left.right != null) sum += node.left.right.val;
                }
            }
            
            if(node.right != null){
                queue.add(node.right);
                if(node.val % 2 == 0){
                    if(node.right.left != null) sum += node.right.left.val;
                    if(node.right.right != null) sum += node.right.right.val;
                }
            }
        }
        
        return sum;
    }
}