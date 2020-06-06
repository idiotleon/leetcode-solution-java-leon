/**
 * @author: Leon
 * https://leetcode.com/problems/sentence-similarity-ii/
 * 
 * Time Complexity:     O(words1.length + alpha(pairs.size()))
 *  O(words1.length), to check each word
 *  O(alpha(pairs.size())), to union by size with path compression
 * Space Complexity:    O(2 * pairs.size()) ~ O(pairs.size())
 */
package com.zea7ot.lc.lvl3.lc0737;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0UnionFind1 {
    public boolean areSentencesSimilarTwo(String[] words1, 
                                          String[] words2, 
                                          List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        
        UnionFind uf = new UnionFind(pairs);
        for(int i = 0; i < words1.length; i++){
            String root1 = uf.find(words1[i]), root2 = uf.find(words2[i]);
            // if any different root(s) (of UnionFind) detected for any pair of words
            if(!root1.equals(root2)){
                return false;
            }
        }
        
        return true;
    }
    
    
    private class UnionFind{
        private Map<String, String> nodesToRoots;
        // mainly for the convenience of path compression
        private Map<String, List<String>> rootsToNodes;
        
        protected UnionFind(List<List<String>> pairs){
            nodesToRoots = new HashMap<String, String>();
            rootsToNodes = new HashMap<String, List<String>>();
            
            for(List<String> pair : pairs){
                String str1 = pair.get(0), str2 = pair.get(1);
                union(str1, str2);
            }
        }
        
        private void union(String str1, String str2){
            if(!nodesToRoots.containsKey(str1) && !nodesToRoots.containsKey(str2)){ // if neither has been met
                nodesToRoots.put(str1, str1);
                nodesToRoots.put(str2, str1);
                rootsToNodes.putIfAbsent(str1, new ArrayList<String>());
                rootsToNodes.get(str1).add(str2);
            }else if(nodesToRoots.containsKey(str1) && !nodesToRoots.containsKey(str2)){ // if only str1 has been met
                String root1 = nodesToRoots.get(str1);
                nodesToRoots.put(str2, root1);
                rootsToNodes.putIfAbsent(str1, new ArrayList<String>());
                rootsToNodes.get(root1).add(str2);
            }else if(!nodesToRoots.containsKey(str1) && nodesToRoots.containsKey(str2)){ // if only str2 has been met
                String root2 = nodesToRoots.get(str2);
                nodesToRoots.put(str1, root2);
                rootsToNodes.putIfAbsent(str2, new ArrayList<String>());
                rootsToNodes.get(root2).add(str1);
            }else{  // if both have been met
                String root1 = nodesToRoots.get(str1), root2 = nodesToRoots.get(str2);
                if(!root1.equals(root2)){   // to ignore cases where they have the same root
                    // to union by size
                    List<String> list1 = rootsToNodes.get(root1), list2 = rootsToNodes.get(root2);
                    if(list1.size() > list2.size()){
                        for(String node : list2){
                            nodesToRoots.put(node, root1);
                        }
                        // do not forget this step
                        nodesToRoots.put(root2, root1);
                        rootsToNodes.get(root1).addAll(list2);
                        // do not forget this step
                        rootsToNodes.get(root1).add(root2);
                        list2.clear();
                    }else{
                        for(String node : list1){
                            nodesToRoots.put(node, root2);
                        }
                        // do not forget this step
                        nodesToRoots.put(root1, root2);
                        rootsToNodes.get(root2).addAll(list1);
                        // do not forget this step
                        rootsToNodes.get(root2).add(root1);
                        list1.clear();
                    }
                }
            }
        }
        
        protected String find(String str){
            if(!nodesToRoots.containsKey(str)) return str;
            return nodesToRoots.get(str);
        }
    }
}