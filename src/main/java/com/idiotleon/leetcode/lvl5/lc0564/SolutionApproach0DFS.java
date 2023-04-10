/**
 * https://leetcode.com/problems/find-the-closest-palindrome/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/find-the-closest-palindrome/discuss/102389/Java-solution-with-detailed-proof
 */
package com.idiotleon.leetcode.lvl5.lc0564;

public class SolutionApproach0DFS {
    public String nearestPalindromic(String n) {
        final int L = n.length();
        char[] chs = n.toCharArray();
        for(int i = 0, j = L - 1; i < j; i++, j--){
            chs[j] = chs[i];
        }
        
        String curP = String.valueOf(chs);
        String prevP = nearestPalindrome(curP, false);
        String nextP = nearestPalindrome(curP, true);
        
        long num = Long.valueOf(n);
        long cur = Long.valueOf(curP);
        long prev = Long.valueOf(prevP);
        long next = Long.valueOf(nextP);
        
        long d1 = Math.abs(num - prev);
        long d2 = Math.abs(num - cur);
        long d3 = Math.abs(num - next);
        
        if(num == cur) return d1 <= d3 ? prevP : nextP;
        else if(num > cur) return d2 <= d3 ? curP : nextP;
        else return d1 <= d2 ? prevP : curP;
    }
    
    private String nearestPalindrome(String curP, boolean dir){
        int k = curP.length() >> 1, p = curP.length() - k;
        int l = Integer.valueOf(curP.substring(0, p));
        l += (dir ? 1 : -1);
        
        if(l == 0) return k == 0 ? "0" : "9";
        
        StringBuilder left = new StringBuilder(String.valueOf(l));
        StringBuilder right = new StringBuilder(left).reverse();
        if(k > left.length()) right.append("9");
        
        return left.append(right.substring(right.length() - k)).toString();
    }
}