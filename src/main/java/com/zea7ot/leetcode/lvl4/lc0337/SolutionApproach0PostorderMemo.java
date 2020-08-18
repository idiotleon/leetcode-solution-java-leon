/**
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
 */
package com.zea7ot.leetcode.lvl4.lc0337;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderMemo {
    public int rob(TreeNode root) {
        return postorder(root, new HashMap<TreeNode, Integer>());
    }
    
    private int postorder(TreeNode node, Map<TreeNode, Integer> map){
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        
        int val = 0;
        if(node.left != null){
            val += postorder(node.left.left, map) + postorder(node.left.right, map);
        }
        
        if(node.right != null){
            val += postorder(node.right.left, map) + postorder(node.right.right, map);
        }
        
        val = Math.max(val + node.val, postorder(node.left, map) + postorder(node.right, map));
        map.put(node, val);
        return val;
    }
}