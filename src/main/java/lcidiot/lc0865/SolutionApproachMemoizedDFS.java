/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
package main.java.lcidiot.lc0865;

import java.util.HashMap;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachMemoizedDFS {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        depth(root, map);
        return dfs(root, map);
    }
    
    private TreeNode dfs(TreeNode root, HashMap<TreeNode, Integer> map){
        int left = depth(root.left, map);
        int right = depth(root.right, map);
        if(left == right) return root;
        if(left > right) return dfs(root.left, map);
        return dfs(root.right, map);
    }
    
    private int depth(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int max = Math.max(depth(root.left, map), depth(root.right, map)) + 1;
        map.put(root, max);
        return max;
    }
}