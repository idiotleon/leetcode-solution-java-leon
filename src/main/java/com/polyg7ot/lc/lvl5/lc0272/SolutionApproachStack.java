/**
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/
 */
package com.polyg7ot.lc.lvl5.lc0272;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.polyg7ot.data_structure.tree.TreeNode;

public class SolutionApproachStack {
    private Stack<TreeNode> leftStack;
    private Stack<TreeNode> rightStack;
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        // initialization
        leftStack = new Stack<TreeNode>();
        rightStack= new Stack<TreeNode>();
        
        TreeNode cur = root;
        while(cur != null){
            if(target <= cur.val){
                rightStack.push(cur);
                cur = cur.left;
            }else{
                leftStack.push(cur);
                cur = cur.right;
            }
        }
        
        // to get predecessors and successors
        List<Integer> predecessors = getPredecessor(k);
        List<Integer> successors = getSuccessor(k);
        
        int lIdx = 0, rIdx = 0;
        while(lIdx < predecessors.size() || rIdx < successors.size()){
            if(ans.size() == k) break;
            
            if(lIdx == predecessors.size()){
                ans.add(successors.get(rIdx++));
            }else if(rIdx == successors.size()){
                ans.add(predecessors.get(lIdx++));
            }else if(Math.abs(predecessors.get(lIdx) - target) < Math.abs(Math.abs(successors.get(rIdx) - target))){
                ans.add(predecessors.get(lIdx++));
            }else{
                ans.add(successors.get(rIdx++));
            }
        }
        
        return ans;
    }
    
    private List<Integer> getPredecessor(int k){
        List<Integer> res = new ArrayList<Integer>();
        while(!leftStack.isEmpty()){
            TreeNode cur = leftStack.pop();     
            res.add(cur.val);
            if(res.size() == k) break;
            
            cur = cur.left;
            while(cur != null){
                leftStack.add(cur);
                cur = cur.right;
            }
        }
        
        return res;
    }
    
    private List<Integer> getSuccessor(int k){
        List<Integer> res = new ArrayList<Integer>();
        while(!rightStack.isEmpty()){
            TreeNode cur = rightStack.pop();
            res.add(cur.val);
            if(res.size() == k) break;
            
            cur = cur.right;
            while(cur != null){
                rightStack.add(cur);
                cur = cur.left;
            }
        }
        
        return res;
    }
}