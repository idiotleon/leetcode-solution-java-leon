/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/trim-a-binary-search-tree/discuss/107000/Java-solution-6-liner/314989
 *  https://leetcode.com/problems/trim-a-binary-search-tree/discuss/107000/Java-solution-6-liner
 */
package com.zea7ot.leetcode.lvl2.lc0669;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // sanity check
        if(root == null) return null;
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        if(root.val < L) return trimBST(root.right, L, R);
        if(root.val > R) return trimBST(root.left, L, R);
        
        return root;
    }
}