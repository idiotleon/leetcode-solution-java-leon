package com.zea7ot.leetcode.lvl2.lc0589;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0PreorderRecursive {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        preorder(root, ans);
        return ans;
    }
    
    private void preorder(Node node, List<Integer> res){
        if(node == null) return;
        
        res.add(node.val);
        for(Node child : node.children)
            preorder(child, res);
    }
}