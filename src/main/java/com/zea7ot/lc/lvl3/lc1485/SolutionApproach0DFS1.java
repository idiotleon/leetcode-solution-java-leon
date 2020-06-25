/**
 * https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/clone-binary-tree-with-random-pointer/discuss/692863/Simple-~Single-Pass~-DFS-with-a-HashMap-O(n)-Java/592615
 *  https://leetcode.com/problems/clone-binary-tree-with-random-pointer/discuss/692863/Simple-~Single-Pass~-DFS-with-a-HashMap-O(n)-Java
 */
package com.zea7ot.lc.lvl3.lc1485;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFS1 {
    private Map<Node, NodeCopy> map = new HashMap<Node, NodeCopy>();
    
    public NodeCopy copyRandomBinaryTree(Node root) {
        // sanity check
        if(root == null) return null;
        
        map.put(root, new NodeCopy(root.val));
        if(!map.containsKey(root.left)){
            map.put(root.left, copyRandomBinaryTree(root.left));
        }
        map.get(root).left = map.get(root.left);
        
        if(!map.containsKey(root.right)){
            map.put(root.right, copyRandomBinaryTree(root.right));
        }
        map.get(root).right = map.get(root.right);
        
        if(!map.containsKey(root.random)){
            map.put(root.random, copyRandomBinaryTree(root.random));
        }
        map.get(root).random = map.get(root.random);
        
        return map.get(root);
    }
}