/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 * 
 * Time Complexity:     O(M + N)
 *  M, amount of nodes of the linked list
 *  N, amount of nodes of the tree
 * 
 * Space Complexity:    O(H + M)
 *  H, height of the tree
 *  M, amount of nodes of the linked list
 * 
 * References:
 *  https://leetcode.com/problems/linked-list-in-binary-tree/discuss/535370/Java-KMP-Search-O(m%2Bn)-Clean-code
 */
package com.zea7ot.leetcode.lvl3.lc1367;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;
import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0KMPAlgorithm {
    public boolean isSubPath(ListNode head, TreeNode root) {
        int[] needle = toArray(head);
        int[] kmpTable = getKMPTable(needle);
        return kmpSearch(root, 0, kmpTable, needle);
    }
    
    private boolean kmpSearch(TreeNode node, int j, int[] kmpTable, int[] needle){
        if(j == needle.length) return true;
        if(node == null) return false;
        while(j > 0 && node.val != needle[j]) j = kmpTable[j - 1];
        if(node.val == needle[j]) j++;
        return kmpSearch(node.left, j, kmpTable, needle) || kmpSearch(node.right, j, kmpTable, needle);
    }
    
    private int[] getKMPTable(int[] pattern){
        final int N = pattern.length;
        int[] kmpTable = new int[N];
        for(int i = 1, j = 0; i < N; i++){
            while(j > 0 && pattern[i] != pattern[j]) j = kmpTable[j - 1];
            if(pattern[i] == pattern[j]) kmpTable[i] = ++j;
        }
        
        return kmpTable;
    }
    
    private int[] toArray(ListNode head){
        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}