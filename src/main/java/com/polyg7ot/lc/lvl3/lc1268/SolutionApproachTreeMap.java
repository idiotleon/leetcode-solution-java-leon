/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
package com.polyg7ot.lc.lvl3.lc1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SolutionApproachTreeMap {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(products == null || products.length == 0) return res;
        
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        Arrays.sort(products);
        List<String> productsList = Arrays.asList(products);
        
        for(int i = 0; i < products.length; i++){
            map.put(products[i], i);
        }
        
        String key = "";
        for(char c : searchWord.toCharArray()){
            key += c;
            String ceiling = map.ceilingKey(key);
            String floor = map.floorKey(key + "~");
            if(ceiling == null || floor == null) break;
            res.add(productsList.subList(map.get(ceiling), 
                    Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }
        
        while(res.size() < searchWord.length()){
            res.add(new ArrayList<String>());
        }
        
        return res;
    }
}