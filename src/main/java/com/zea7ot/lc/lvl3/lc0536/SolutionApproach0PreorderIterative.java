/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a reverse iterative preorder traversal
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-string/discuss/100359/Java-stack-solution
 */
package com.zea7ot.lc.lvl3.lc0536;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderIterative {
    public TreeNode str2tree(String s) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        char[] chs = s.toCharArray();
        final int L = s.length();
        
        int lo = 0, hi = 0;
        while(hi < L){
            char ch = chs[hi];
            if(ch == ')') stack.pop();
            else if(ch >= '0' && ch <= '9' || ch == '-'){
                while(hi + 1 < L && chs[hi + 1] >= '0' && chs[hi + 1] <= '9') hi++;
                TreeNode newNode = new TreeNode(Integer.parseInt(new String(chs, lo, hi + 1 - lo)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null) parent.right = newNode;
                    else parent.left = newNode;
                }
                stack.push(newNode);
            }
            
            hi++;
            lo = hi;
        }
        
        return stack.isEmpty() ? null : stack.peek();
    }
}