/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * https://leetcode.com/problems/binary-search-tree-iterator/discuss/52526/Ideal-Solution-using-Stack-(Java)
 */
package main.java.lcidiot.lc.lvl4.lc0173;

import java.util.Stack;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachStack {
    private final Stack<TreeNode> stack;

    public SolutionApproachStack(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        
        // to traverse the right branch of cur[node]
        TreeNode cur = node.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}