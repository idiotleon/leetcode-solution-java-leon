/**
 * https://leetcode.com/problems/letter-case-permutation/
 * 
 * Time Complexity:     O(2 ^ letters(L)) ~ O(2 ^ L)
 *  L, length of the input String S
 *  letters(L), the length of letters, not digits, in String S
 * 
 * Space Complexity:    O(L) + O(L) ~ O(L)
 * 
 * References:
 *  https://leetcode.com/problems/letter-case-permutation/discuss/656296/Java-Clean-Code-DFS-%2B-BFS
 */
package com.zea7ot.leetcode.lvl2.lc0784;

import java.util.ArrayList;
import java.util.List;

public class SolutionApproach0DFS {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(S == null || S.isEmpty()) return ans;
        
        dfs(S.toCharArray(), 0, ans);
        return ans;
    }
    
    private void dfs(char[] chs, int idx, List<String> res){
        if(idx >= chs.length){
            res.add(String.valueOf(chs));
            return;
        }
        
        if(chs[idx] >= '0' && chs[idx] <= '9'){
            dfs(chs, idx + 1, res);
            return;
        }
        
        chs[idx] = Character.toLowerCase(chs[idx]);
        dfs(chs, idx + 1, res);
        
        chs[idx] = Character.toUpperCase(chs[idx]);
        dfs(chs, idx + 1, res);
    }
}