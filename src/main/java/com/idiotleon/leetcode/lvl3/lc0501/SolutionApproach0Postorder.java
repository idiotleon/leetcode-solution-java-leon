/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/most-frequent-subtree-sum/discuss/98675/JavaC%2B%2BPython-DFS-Find-Subtree-Sum
 */
package com.idiotleon.leetcode.lvl3.lc0501;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.idiotleon.util.data_structure.tree.TreeNode;

public class SolutionApproach0Postorder {
    private int maxCount = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        postorder(root, freq);
        
        List<Integer> ans = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() == maxCount) ans.add(entry.getKey());
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    private int postorder(TreeNode node, Map<Integer, Integer> freq){
        if(node == null) return 0;
        int sum = postorder(node.left, freq) + postorder(node.right, freq) + node.val;
        freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, freq.get(sum));
        return sum;
    }
}