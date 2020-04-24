/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
package main.java.lcidiot.lc.lvl4.lc0117;

import main.java.lcidiot.data_structure.tree.TreeNodeWithNextPtr;

public class SolutionApproachBFSWithoutQueue {
    public TreeNodeWithNextPtr connect(TreeNodeWithNextPtr root) {
        TreeNodeWithNextPtr head = root;
        
        while(head != null){
            TreeNodeWithNextPtr nextHead = new TreeNodeWithNextPtr(-1), nextTail = nextHead;
            
            TreeNodeWithNextPtr cur = head;
            while(cur != null){
                if(cur.left != null){
                    nextTail.next = cur.left;
                    nextTail = cur.left;
                }
                
                if(cur.right != null){
                    nextTail.next = cur.right;
                    nextTail = cur.right;
                }
                
                cur = cur.next;
            }
            
            head = nextHead.next;
        }
        
        return root;
    }
}