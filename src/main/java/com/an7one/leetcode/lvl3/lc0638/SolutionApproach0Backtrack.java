/**
 * https://leetcode.com/problems/shopping-offers/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/shopping-offers/discuss/105212/Very-Easy-to-understand-JAVA-Solution-beats-95-with-explanation
 */
package com.an7one.leetcode.lvl3.lc0638;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0Backtrack {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(0, price, special, needs);
    }
    
    private int dfs(int start,
                    List<Integer> price, 
                    List<List<Integer>> special, 
                    List<Integer> needs){
        int localMin = directPurchase(price, needs);
        for(int i = start; i < special.size(); i++){
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < needs.size(); j++){
                if(needs.get(j) < offer.get(j)){
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }
            
            if(temp != null){
                localMin = Math.min(localMin, offer.get(offer.size() - 1) + dfs(i, price, special, temp));
            }
        }
        
        return localMin;
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs){
        int total = 0;
        for(int i = 0; i < needs.size(); i++){
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}