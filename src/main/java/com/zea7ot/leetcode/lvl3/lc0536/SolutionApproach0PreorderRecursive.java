/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 * 
 * Time Complexity:     O(L)
 * Space ComplexityL    O(lg(L))
 * 
 * References:
 *  
 */
package com.zea7ot.leetcode.lvl3.lc0536;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public TreeNode str2tree(String str) {
        // sanity check
        if(str == null || str.isEmpty()) return null;
        
        final int L = str.length();
        char[] chs = str.toCharArray();
        
        int lo = 0, hi = 0;
        while(hi < L && (chs[hi] >= '0' && chs[hi] <= '9' || chs[hi] == '-')) hi++;
        TreeNode root = new TreeNode(Integer.parseInt(str.substring(lo, hi)));
        
        if(hi < L){
            lo = hi;
            int count = 1;
            while(hi + 1 < L && count > 0){
                hi++;
                if(chs[hi] == ')') --count;
                if(chs[hi] == '(') ++count;
            }
            root.left = str2tree(str.substring(lo + 1, hi));
        }
        
        hi++;
        if(hi < L)
            root.right = str2tree(str.substring(hi + 1, L - 1));
        
        return root;
    }
}