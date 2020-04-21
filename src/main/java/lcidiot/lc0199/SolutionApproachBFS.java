/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
package main.java.lcidiot.lc0199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachBFS {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int maxDepth = -1;
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);
        
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();
            
            if(node != null){
                maxDepth = Math.max(maxDepth, depth);
                rightmostValueAtDepth.put(depth, node.val);
                
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        
        List<Integer> rightView = new ArrayList<Integer>();
        for(int depth = 0; depth <= maxDepth; depth++){
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        
        return rightView;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> result = new ArrayList<Integer>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                TreeNode cur = queue.poll();
                
                if(size == 0) {
                    result.add(cur.val);
                }
                
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        
        return result;
    }
}