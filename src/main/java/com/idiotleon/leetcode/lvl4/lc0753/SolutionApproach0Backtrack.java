/**
 * https://leetcode.com/problems/cracking-the-safe/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/cracking-the-safe/discuss/153039/DFS-with-Explanations
 */
package com.idiotleon.leetcode.lvl4.lc0753;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SolutionApproach0Backtrack {
    public String crackSafe(int n, int k) {
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder password = new StringBuilder(strPwd);
        
        Set<String> existing = new HashSet<String>();
        existing.add(strPwd);
        
        int targetNumVisited = (int)Math.pow(k, n);
        backtrack(password, existing, targetNumVisited, n, k);
        
        return password.toString();
    }
    
    private boolean backtrack(StringBuilder password, 
                              Set<String> existing, 
                              int targetNumVisited, 
                              int n, 
                              int k){
        if(existing.size() == targetNumVisited) return true;
        
        String lastDigits = password.substring(password.length() - n + 1); // last (n - 1) digits of `password`
        for(char ch = '0'; ch < '0' + k; ch++){
            String newComb = lastDigits + ch;
            if(existing.contains(newComb)) continue;
            existing.add(newComb);
            password.append(ch);
            if(backtrack(password, existing, targetNumVisited, n, k)) return true;
            existing.remove(newComb);
            password.deleteCharAt(password.length() - 1);
        }
        
        return false;
    }
}