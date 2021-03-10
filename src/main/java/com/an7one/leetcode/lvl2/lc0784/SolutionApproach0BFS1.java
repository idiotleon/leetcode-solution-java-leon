/**
 * @author: Leon
 * https://leetcode.com/problems/letter-case-permutation/
 * 
 * Time Complexity:     O(digit(L) + 2 ^ letter(L)) ~ O(2 ^ L)
 *  L, the length of the String S
 * 
 * Space Complexity:    O(2 ^ letter(L))
 *  L, the length of the String S
 */
package com.an7one.leetcode.lvl2.lc0784;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionApproach0BFS1 {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(S == null || S.isEmpty()) return ans;
        
        char[] chs = S.toCharArray();
        int idx = 0;
        
        Queue<StringBuilder> queue = new LinkedList<StringBuilder>();
        queue.add(new StringBuilder());
        
        while(!queue.isEmpty()){
            final int SIZE = queue.size();
            char ch = chs[idx];
            
            for(int j = 0; j < SIZE; j++){
                StringBuilder cur = queue.poll();
                
                if(ch >= '0' && ch <= '9'){
                    cur.append(ch);
                    queue.offer(cur);
                }else{
                    StringBuilder transform = new StringBuilder(cur);
                    cur.append(Character.toUpperCase(ch));
                    queue.offer(cur);
                    transform.append(Character.toLowerCase(ch));
                    queue.offer(transform);
                }
            }
            
            idx++;
            if(idx == chs.length) break;
        }
        
        while(!queue.isEmpty()) ans.add(queue.poll().toString());
        
        return ans;
    }
}