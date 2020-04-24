/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
 */
package main.java.lcidiot.lc.lvl4.lc0298;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFSTopDown {
    private int max;
    
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        dfs(root, 0, root.val);
        return max;
    }
    
    private void dfs(TreeNode node, int sequence, int target){
        if(node == null) return;
        if(node.val == target) sequence++;
        else sequence = 1;
        max = Math.max(max, sequence);
        dfs(node.left, sequence, node.val + 1);
        dfs(node.right, sequence, node.val + 1);
    }
}