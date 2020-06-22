/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/477048/JavaC%2B%2BPython-1-Line-Recursive-Solution
 */
package com.zea7ot.lc.lvl2.lc1315;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 1, 1);
    }
    
    private int dfs(TreeNode node, int parent, int grandParent){
        if(node == null) return 0;
        return dfs(node.left, node.val, parent) 
                + dfs(node.right, node.val, parent) 
                + (grandParent % 2 == 0 ? node.val : 0);
    }
}