/**
 * https://leetcode.com/problems/permutations-ii/
 */

package main.java.lcidiot.lc0047;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums, 
                     boolean[] visited){
        
        if(intermediate.size() == nums.length){
            ans.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            intermediate.add(nums[i]);
            dfs(ans, intermediate, nums, visited);
            visited[i] = false;
            intermediate.remove(intermediate.size() - 1);
        }
    }
}