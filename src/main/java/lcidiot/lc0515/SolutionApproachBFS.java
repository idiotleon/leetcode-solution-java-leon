/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
package main.java.lcidiot.lc0515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.lcidiot.utils.TreeNode;

public class SolutionApproachBFS {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                max = Math.max(max, cur.val);
                
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            
            ans.add(max);
        }
        
        return ans;
    }
}