/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    ?O()
 * 
 * References:
 *  https://leetcode.com/problems/average-of-levels-in-binary-tree/discuss/105158/Java-solution-using-DFS-with-full-comments
 */
package com.zea7ot.lc.lvl2.lc0637;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach1DFS {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<Double>();
        // sanity check
        if(root == null) return ans;
        
        List<Integer> counts = new ArrayList<Integer>();
        dfs(0, root, counts, ans);
        
        for(int i = 0; i < ans.size(); i++){
            ans.set(i, ans.get(i) / counts.get(i));
        }
        
        return ans;
    }
    
    private void dfs(int depth, TreeNode node, List<Integer> counts, List<Double> ans){
        if(node == null) return;
        
        if(ans.size() <= depth){
            ans.add(0.0);
            counts.add(0);
        }
        
        ans.set(depth, ans.get(depth) + node.val);
        counts.set(depth, counts.get(depth) + 1);
        
        dfs(depth + 1, node.left, counts, ans);
        dfs(depth + 1, node.right, counts, ans);
    }
}