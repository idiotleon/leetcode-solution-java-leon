/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31493/Java-Solution-with-DP
 */
package com.null7ptr.lc.lvl3.lc0095;

import java.util.ArrayList;
import java.util.List;

import com.null7ptr.data_structure.tree.TreeNode;

public class SolutionApproachDP {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        // sanity check
        if(n == 0) return result[0];
        
        result[0].add(null);
        for(int len = 1; len <= n; len++){
            result[len] = new ArrayList<TreeNode>();
            for(int j = 0; j < len; j++){
                for(TreeNode nodeLeft : result[j]){
                    for(TreeNode nodeRight : result[len - j - 1]){
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeLeft;
                        node.right = clone(nodeRight, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        
        return result[n];
    }
    
    private static TreeNode clone(TreeNode n, int offset){
        if(n == null) return null;
        
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}