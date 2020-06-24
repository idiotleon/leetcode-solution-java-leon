/**
 * https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/clone-binary-tree-with-random-pointer/discuss/692863/Simple-~Single-Pass~-DFS-with-a-HashMap-O(n)-Java
 */
package com.zea7ot.lc.lvl3.lc1485;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0DFSMemo {
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<Node, NodeCopy>();
        return dfs(root, map);
    }
    
    private NodeCopy dfs(Node node, Map<Node, NodeCopy> map){
        if(node == null) return null;
        
        if(map.containsKey(node)) return map.get(node);
        
        NodeCopy newNode = new NodeCopy(node.val);
        map.put(node, newNode);
        
        newNode.left = dfs(node.left, map);
        newNode.right = dfs(node.right, map);
        newNode.random = dfs(node.random, map);
        
        return newNode;
    }
}