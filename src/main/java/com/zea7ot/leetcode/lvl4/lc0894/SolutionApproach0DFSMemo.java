/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://zxi.mytechroad.com/blog/tree/leetcode-894-all-possible-full-binary-trees/
 */
package com.zea7ot.leetcode.lvl4.lc0894;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSMemo {
    private static final int K_MAX_N = 20 + 1;
    
    public List<TreeNode> allPossibleFBT(int N) {
        List<List<TreeNode>> memo = new ArrayList<List<TreeNode>>();
        for(int i = 0; i < K_MAX_N; i++) memo.add(new ArrayList<TreeNode>());
        return dfs(N, memo);
    }
    
    private List<TreeNode> dfs(int N, List<List<TreeNode>> memo){
        if(!memo.get(N).isEmpty()) return memo.get(N);
        if(N % 2 == 0) return new ArrayList<TreeNode>();
        List<TreeNode> ans = memo.get(N);
        if(N == 1) ans = Arrays.asList(new TreeNode(0));
        for(int i = 1; i < N; i += 2){
            for(TreeNode left : dfs(i, memo)){
                for(TreeNode right : dfs(N - i - 1, memo)){
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