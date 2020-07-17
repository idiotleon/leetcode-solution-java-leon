/**
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 * 
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/inorder-successor-in-bst-ii/discuss/231587/Java-find-in-parents-or-find-in-descendents
 */
package com.zea7ot.lc.lvl3.lc0510;

public class SolutionApproach0Inorder {
    public Node inorderSuccessor(Node node) {
        if(node.right == null){
            Node ans = node.parent;
            while(ans != null && ans.val < node.val)
                ans = ans.parent;
            return ans;
        }else{
            Node ans = node.right;
            while(ans.left != null)
                ans = ans.left;
            return ans;
        }
    }
}