/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O(1) + O()
 * 
 * References:
 *  https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution 
 */
package com.zea7ot.lc.lvl3.lc1079;

public class SolutionApproach0Backtrack {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        
        for(char c : tiles.toCharArray()){
            ++freq[c - 'A'];
        }
        
        return backtrack(freq);
    }
    
    private int backtrack(int[] nums){
        int count = 0;
        for(int i = 0; i < 26; i++){
            if(nums[i] == 0) continue;
            count++;
            
            nums[i]--;
            count += backtrack(nums);
            nums[i]++;
        }
        
        return count;
    }
}