/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * 
 * Time Complexity:     O(N) + O(K) ~ O(N)
 * Space Complexity:    O(N) + O(N) ~ O(N)
 * 
 * to keep track of parent nodes in a HashMap
 */
package com.zea7ot.leetcode.lvl4.lc0863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0BFS {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        Map<TreeNode, TreeNode> childToParent = new HashMap<TreeNode, TreeNode>();
        dfs(root, childToParent);
        
        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(target);
        
        while(!queue.isEmpty() && K > 0){
            final int SIZE = queue.size();
            K--;
            
            for(int i = 0; i < SIZE; i++){
                TreeNode cur = queue.poll();
                visited.add(cur);
                
                TreeNode left = cur.left, right = cur.right;
                
                if(left != null && !visited.contains(left)) queue.add(left);
                if(right != null && !visited.contains(right)) queue.add(cur.right);
                if(childToParent.containsKey(cur) 
                   && !visited.contains(childToParent.get(cur))) {
                    queue.add(childToParent.get(cur));
                }
            }
        }
        
        while(!queue.isEmpty()) ans.add(queue.poll().val);
        
        return ans;
    }
    
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> childToParent){
        if(node.left != null) {
            childToParent.put(node.left, node);
            dfs(node.left, childToParent);
        }
        
        if(node.right != null) {
            childToParent.put(node.right, node);
            dfs(node.right, childToParent);
        }
    }
}