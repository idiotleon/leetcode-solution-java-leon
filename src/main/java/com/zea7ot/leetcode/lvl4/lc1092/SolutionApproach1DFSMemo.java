/**
 * https://leetcode.com/problems/shortest-common-supersequence/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O(M * N)
 * 
 * References:
 *  https://leetcode.com/problems/shortest-common-supersequence/discuss/317092/java-Memoization-solution
 */
package com.zea7ot.leetcode.lvl4.lc1092;

public class SolutionApproach1DFSMemo {
    public String shortestCommonSupersequence(String str1, String str2) {
        final int M = str1.length(), N = str2.length();
        String[][] memo = new String[M][N];
        char[] chs1 = str1.toCharArray(), chs2 = str2.toCharArray();
        
        char[] chs = dfs(chs1, 0, chs2, 0, memo).toCharArray();
        if(chs.length == 0) return str1 + str2;
        
        StringBuilder builder = new StringBuilder();
        int i = 0, j = 0;
        for(char ch : chs){
            while(chs1[i] != ch) builder.append(chs1[i++]);
            while(chs2[j] != ch) builder.append(chs2[j++]);
            builder.append(ch);
            i++;
            j++;
        }
        
        builder.append(str1.substring(i));
        builder.append(str2.substring(j));
        
        return builder.toString();
    }
    
    private String dfs(char[] chs1, int i, 
                       char[] chs2, int j, 
                       String[][] memo){
        if(i >= chs1.length || j >= chs2.length) return "";
        
        if(memo[i][j] != null) return memo[i][j];
        
        if(chs1[i] == chs2[j]){
            memo[i][j] = chs1[i] + dfs(chs1, i + 1, chs2, j + 1, memo);
        }else{
            String left = dfs(chs1, i + 1, chs2, j, memo);
            String right = dfs(chs1, i, chs2, j + 1, memo);
            
            memo[i][j] = (left.length() > right.length()) ? left : right;
        }
        
        return memo[i][j];
    }
}