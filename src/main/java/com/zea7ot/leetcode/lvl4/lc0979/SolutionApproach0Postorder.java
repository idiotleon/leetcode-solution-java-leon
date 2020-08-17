/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/307231/Java-Solution-(0-ms)-easy-to-understand
 */
package com.zea7ot.leetcode.lvl4.lc0979;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        
        int[] moves = {0};
        postorder(root, null, moves);
        return moves[0];
    }
    
    private void postorder(TreeNode cur, TreeNode parent, int[] moves){
        if(cur == null) return;
        
        postorder(cur.left, cur, moves);
        postorder(cur.right, cur, moves);
        
        if(cur.val < 1){
            moves[0] += (1 - cur.val);
            parent.val -= (1 - cur.val);
        }else if(cur.val > 1){
            moves[0] += cur.val - 1;
            parent.val += cur.val - 1;
        }
    }
}