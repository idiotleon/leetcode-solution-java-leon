/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 * 
 * References:
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        // sanity check
        if(root == null) return ans;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        postorder(root, map, ans);
        return ans;
    }
    
    private String postorder(TreeNode node, 
                             Map<String, Integer> map, 
                             List<TreeNode> res){
        if(node == null) return "#";
        String serial = node.val + "," + postorder(node.left, map, res) + "," + postorder(node.right, map, res);
        if(map.getOrDefault(serial, 0) == 1) res.add(node);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}