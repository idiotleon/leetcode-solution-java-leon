/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
package main.java.lcidiot.lc.lvl2.lc0199;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.data_structure.tree.TreeNode;

public class SolutionApproachDFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    private void rightView(TreeNode cur, 
                           List<Integer> result, 
                           int curDepth){
        if(cur == null) return;
        
        if(curDepth == result.size()){
            result.add(cur.val);
        }
        
        rightView(cur.right, result, curDepth + 1);
        rightView(cur.left, result, curDepth + 1);
    }
}