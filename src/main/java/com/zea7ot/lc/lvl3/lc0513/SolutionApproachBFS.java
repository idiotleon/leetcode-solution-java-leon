/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
package com.zea7ot.lc.lvl3.lc0513;

import java.util.LinkedList;
import java.util.Queue;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproachBFS {
    public int findBottomLeftValue(TreeNode root) {
        // it is assumed that root is NOT null
        // no need to perform sanity check
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int ans = root.val;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(i == 0) ans = cur.val;
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        
        return ans;
    }
}