/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/boundary-of-binary-tree/discuss/101288/java-recursive-solution-beats-94
 */
package com.zea7ot.lc.lvl4.lc0545;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFS {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root != null){
            ans.add(root.val);
            dfs(true, false, root.left, ans);
            dfs(false, true, root.right, ans);
        }
        
        return ans;
    }
    
    private void dfs(boolean isLeftBoundary, 
                     boolean isRightBoundary, 
                     TreeNode node, 
                     List<Integer> res){
        if(node == null) return;
        
        if(node.left == null && node.right == null){
            res.add(node.val);
            return;
        }
        
        if(isLeftBoundary) res.add(node.val);
        
        dfs(node.left != null && isLeftBoundary, node.right == null && isRightBoundary, node.left, res);
        dfs(node.left == null && isLeftBoundary, node.right != null && isRightBoundary, node.right, res);
        
        if(isRightBoundary) res.add(node.val);
        
    }
}