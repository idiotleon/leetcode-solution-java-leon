/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/tree/leetcode-894-all-possible-full-binary-trees/
 */
package com.an7one.leetcode.lvl4.lc0894;

import java.util.ArrayList;
import java.util.List;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DP {
    public List<TreeNode> allPossibleFBT(int N) {
        // sanity check
        if(N % 2 == 0) return new ArrayList<TreeNode>();
        
        List<List<TreeNode>> dp = new ArrayList<List<TreeNode>>(N + 1);
        for(int i = 0; i < N + 1; i++) dp.add(new ArrayList<TreeNode>());
        dp.get(1).add(new TreeNode(0));
        for(int i = 3; i <= N; i += 2){
            for(int j = 1; j < i; j += 2){
                int k = i - j - 1;
                for(TreeNode left : dp.get(j)){
                    for(TreeNode right : dp.get(k)){
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        dp.get(i).add(root);
                    }
                }
            }
        }
        
        return dp.get(N);
    }
}