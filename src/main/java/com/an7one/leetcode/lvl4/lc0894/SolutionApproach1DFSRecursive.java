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

public class SolutionApproach1DFSRecursive {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if(N % 2 == 0) return ans;
        if(N == 1){
            ans.add(new TreeNode(0));
            return ans;
        }
        
        for(int i = 1; i < N; i += 2){
            for(TreeNode left : allPossibleFBT(i)){
                for(TreeNode right : allPossibleFBT(N - i - 1)){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
}