package com.zea7ot.algorithm.summary.union_find;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindInMap {

    private Map<String, String> roots;
    
    public UnionFindInMap(List<List<String>> pairs){
        this.roots = new HashMap<String, String>();

        // with proper conditions
        for(List<String> pair : pairs){
            union(pair.get(0), pair.get(1));
        }
    }

    public void union(String str1, String str2){
        String root1 = findWithPathCompression(str1), root2 = findWithPathCompression(str2);
        if(root1.equals(root2)) return;
        roots.put(root2, root1);
    }
    
    // with path compression
    public String findWithPathCompression(String x) {
        if(x != roots.get(x)){
            roots.put(roots.get(x), findWithPathCompression(roots.get(x)));
        }
        
        return roots.get(x);
    }

    public String findWithPathCompression2(Map<String, String> roots, String word){
        if(!roots.containsKey(word)){
            roots.put(word, word);
            return word;
        }
        
        while(!roots.get(word).equals(word)){
            if(roots.containsKey(roots.get(word))){
                // path compression
                roots.put(word, roots.get(word));   
            }
            word = roots.get(word); 
        }
        
        return word;
    }
}