/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/construct-string-from-binary-tree/discuss/104098/JavaC%2B%2B-1-liner
 */
package com.zea7ot.leetcode.lvl2.lc0606;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0InorderRecursive1 {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String str = new String(t.val + "");
        if(t.left != null) str += "(" + tree2str(t.left) + ")";
        else if(t.right != null) str += "()";
        if(t.right != null) str += "(" + tree2str(t.right) + ")";
        return str;
    }
}