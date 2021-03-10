/**
 * @author: Leon
 * https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
 * 
 * Time Complexities:
 *  serialize:      O(N)
 *  deserialize:    O(N)
 * 
 * Space Compelxity:
 *  serialize():    O(N)
 *  deserialize():  O(N)
 */
package com.an7one.leetcode.lvl4.lc0428;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    // Encodes a tree to a single string.
    public String serialize(NarryTreeNode root) {
        // sanity check
        if(root == null) return "";
            
        Queue<NarryTreeNode> queue = new LinkedList<NarryTreeNode>();
        queue.add(root);
        
        List<String> res = new ArrayList<String>();
        res.add(Integer.toString(root.val));
        res.add("null");
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; i++){
                NarryTreeNode cur = queue.poll();
                
                if(cur.children == null || cur.children.isEmpty()) 
                    res.add("null");
                else {
                    for(NarryTreeNode child : cur.children){
                        res.add(Integer.toString(child.val));
                        queue.add(child);
                    }
                        
                    res.add("null");
                }
            }            
        }
          
        // to remove all tail "null"s
        while(!res.isEmpty() && res.get(res.size() - 1).equals("null")){
            res.remove(res.size() - 1);
        }
            
        return String.join(",", res);
    }
    
    // Decodes your encoded data to tree.
    public NarryTreeNode deserialize(String data) {
        // sanity check
        if(data == null || data.isEmpty()) return null;
            
        String[] args = data.split(",");
            
        final int N = args.length;
            
        int idx = 0;
        while(idx < N && !args[idx].equals("null")) idx++;
        idx++;
            
        NarryTreeNode root = new NarryTreeNode(Integer.parseInt(args[0]));
            
        Queue<NarryTreeNode> queue = new LinkedList<NarryTreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            
            for(int i = 0; i < SIZE; i++){
                NarryTreeNode top = queue.poll();
                
                List<NarryTreeNode> children = new ArrayList<NarryTreeNode>();
                while(idx < N && !args[idx].equals("null")){
                    NarryTreeNode child = new NarryTreeNode(Integer.parseInt(args[idx]));
                    children.add(child);
                    queue.add(child);
                    idx++;
                }
                top.children = children;
                    
                idx++;
            }
        }
        
        return root;
    }


    /**
     * to exactly match what has been given by the problem
     */
    private class NarryTreeNode{
        protected int val;
        protected List<NarryTreeNode> children;

        protected NarryTreeNode(int val){
            this.val = val;
        }

        @SuppressWarnings("unused")
        protected NarryTreeNode(int val, List<NarryTreeNode> children){
            this.val = val;
            this.children = children;
        }
    }
}