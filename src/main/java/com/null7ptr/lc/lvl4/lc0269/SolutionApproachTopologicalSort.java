/**
 * https://leetcode.com/problems/alien-dictionary/
 * 
 * Time Complexity: O(N + M) - N represents all vertices, M represents all edges
 */
package com.null7ptr.lc.lvl4.lc0269;

import java.awt.Point;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionApproachTopologicalSort {
    public String alienOrder(String[] words) {
        List<Point> pairs = new ArrayList<Point>();
        Set<Character> chs = new HashSet<Character>();
        
        final int L = words.length;
        
        // to build up the graph
        for(int i = 0; i < L; i++){
            String word = words[i];
            boolean alreadySet = false;
            int j;
            for(j = 0; j < word.length(); j++){
                if(!alreadySet && i > 0 && j < words[i - 1].length() && words[i].charAt(j) != words[i - 1].charAt(j)){
                    pairs.add(new Point(words[i].charAt(j), words[i - 1].charAt(j)));
                    alreadySet = true;
                }
                
                chs.add(word.charAt(j));
            }
            
            if(!alreadySet && i > 0 && j < words[i - 1].length()) return "";
        }
        
        // to toplogical sort
        String res = "";
        int[] indegree = new int[256];
        Arrays.fill(indegree, Integer.MIN_VALUE);
        
        for(Character ch : chs) indegree[ch] = 0;
        for(int i = 0; i < pairs.size(); i++){
            ++indegree[pairs.get(i).x];
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        for(int i = 0; i < 256; i++){
            if(indegree[i] == 0){
                res += (char) i;
                queue.offer((char) i);
            }
        }
        
        while(!queue.isEmpty()){
            Character predecessor = queue.poll();
            
            for(int i = 0; i < pairs.size(); i++){
                if(pairs.get(i).y == predecessor){
                    --indegree[pairs.get(i).x];
                    if(indegree[pairs.get(i).x] == 0){
                        res += (char) pairs.get(i).x;
                        queue.offer((char) pairs.get(i).x);
                    }
                }
            }
        }
        
        return res.length() == chs.size() ? res : "";
    }
}