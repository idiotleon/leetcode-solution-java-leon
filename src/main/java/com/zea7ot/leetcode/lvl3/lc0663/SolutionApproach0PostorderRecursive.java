/**
 * https://leetcode.com/problems/equal-tree-partition/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/equal-tree-partition/discuss/106727/JavaC%2B%2B-Simple-solution-with-only-one-HashMaplessgreater.
 */
package com.zea7ot.leetcode.lvl3.lc0663;

import java.util.HashMap;
import java.util.Map;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PostorderRecursive {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = getSum(root, map);
        if(sum == 0) return map.getOrDefault(sum, 0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }
    
    private int getSum(TreeNode node, Map<Integer, Integer> map){
        if(node == null) return 0;
        int sum = node.val + getSum(node.left, map) + getSum(node.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}