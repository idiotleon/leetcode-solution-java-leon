/**
 * https://leetcode.com/problems/letter-case-permutation/
 * 
 * Time Complexity:     O(L + 2 ^ letter(L))
 *  L, length of S
 *  letter(L), length of all letters of S
 * 
 * Space Complexity:    O(L + 2 ^ letter(L)) ~ O(2 ^ L)
 *  L, length of S
 *  letter(L), length of all letters of S
 * 
 * References:
 *  https://leetcode.com/problems/letter-case-permutation/discuss/656296/Java-Clean-Code-DFS-%2B-BFS
 */
package com.zea7ot.leetcode.lvl2.lc0784;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(S == null || S.isEmpty()) return ans;
        
        final int L = S.length();
        char[] chs = S.toCharArray();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(S);
            
        for(int i = 0; i < L; i++){
            if(chs[i] >= '0' && chs[i] <= '9') continue;
            
            for(int size = queue.size(); size > 0; size--){
                char[] cur = queue.poll().toCharArray();

                char ch = cur[i];
                
                cur[i] = Character.toLowerCase(ch);
                queue.offer(String.valueOf(cur));

                cur[i] = Character.toUpperCase(ch);
                queue.offer(String.valueOf(cur));
            }
        }
        
        return new ArrayList<String>(queue);
    }
}