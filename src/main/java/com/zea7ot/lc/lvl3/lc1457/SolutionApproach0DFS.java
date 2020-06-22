/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(H + K)
 * 
 * References:
 *  https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/648534/JavaC%2B%2BPython-At-most-one-odd-occurrence
 */
package com.zea7ot.lc.lvl3.lc1457;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int count){
        if(node == null) return 0;
        count ^= 1 << (node.val - 1);
        int res = dfs(node.left, count) + dfs(node.right, count);
        if(node.left == node.right && (count & (count - 1)) == 0) res++;
        return res;
    }
}