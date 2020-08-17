/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Time Complexity: O(N), O(N ^ 2) in the worst case
 * Space Complexity: O(lg(N))
 * 
 * References:
 *  https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/63660/3-ways-implemented-in-JAVA-(Python)%3A-Binary-Search-in-order-iterative-and-recursive
 */
package com.zea7ot.leetcode.lvl4.lc0230;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1BinarySearch {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if(k <= count){
            return kthSmallest(root.left, k);
        }else if(k > count + 1){
            return kthSmallest(root.right, k - 1 - count);
        }
        
        return root.val;
    }
    
    private int countNodes(TreeNode node){
        if(node == null) return 0;
        
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}