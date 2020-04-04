/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 * 
 * Top-Down DFS
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/discuss/231117/java-dfs-on/246263
 * http://www.noteanddata.com/leetcode-988-Smallest-String-Starting-From-Leaf-java-solution-update.html
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/discuss/244205/Divide-and-conquer-technique-doesn't-work-for-this-problem
 */
package main.java.lcidiot.lc0988;

import main.java.lcidiot.utils.TreeNode;

public class SolutionApproachDFS {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    private String dfs(TreeNode node, String suffix){
        if(node == null) return suffix;
        
        suffix = "" + (char)('a' + node.val) + suffix;
        if(node.left == null || node.right == null){
            return (node.left == null) ? dfs(node.right, suffix) : dfs(node.left, suffix);
        }
        
        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);
        
        return left.compareTo(right) <= 0 ? left : right;
    }
}