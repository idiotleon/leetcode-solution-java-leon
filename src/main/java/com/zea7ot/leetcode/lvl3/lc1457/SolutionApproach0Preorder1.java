/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(K * H)
 *  or O(K + H) if discarded sets can be considered as immediately garbage collected
 * 
 * References:
 *  https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648534/JavaC%2B%2BPython-At-most-one-odd-occurrence
 */
package com.zea7ot.leetcode.lvl3.lc1457;

import java.util.HashSet;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Preorder1 {
    public int pseudoPalindromicPaths (TreeNode root) {
        return preorder(root, new HashSet<Integer>());
    }
    
    private int preorder(TreeNode node, Set<Integer> odd){
        if(node == null) return 0;
        
        if(odd.contains(node.val)) odd.remove(node.val);
        else odd.add(node.val);
        
        int res = preorder(node.left, new HashSet<Integer>(odd)) + preorder(node.right, new HashSet<Integer>(odd));
        if(node.left == null && node.right == null && odd.size() <= 1) res++;
        return res;
    }
}