/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
package main.java.lcidiot.lc.lvl3.lc0106;

import java.util.HashMap;
import java.util.Map;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    private int postIdx;
    private int[] postorder;
    private Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        
        this.postorder = postorder;
        this.postIdx = postorder.length - 1;
        
        for(int i = 0; i < postorder.length; i++){
            idxMap.put(inorder[i], i);
        }
        
        return dfs(0, postorder.length);
    }
    
    private TreeNode dfs(int inorderLeft, int inorderRight){
        if(inorderLeft == inorderRight) return null;
        
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        
        postIdx--;
        root.right = dfs(index + 1, inorderRight);
        root.left = dfs(inorderLeft, index);
        
        return root;
    }
}