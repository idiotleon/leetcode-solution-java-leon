/**
 * https://leetcode.com/problems/two-sum-bsts/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/two-sum-bsts/discuss/397595/Java-recursive-solution-in-5-lines
 */
package com.zea7ot.lc.lvl2.lc1214;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach2DFSNaively {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        int sum = root1.val + root2.val;
        if(sum == target) return true;
        else if(sum > target) return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
        else return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
    }
}