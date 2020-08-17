/**
 * https://leetcode.com/problems/zuma-game/
 * 
 * this approach FAILs with the test case:
 *  "RRWWRRBBRR"
 *  "WB"
 * (expected output: 2: 
 *  RRWWRRBBRR -> RRWW[W]RRBBRR -> RRRRBBRR -> RRRRB[B]BRR -> RRRRR -> empty)
 * 
 * but it is a good example for backtracking
 * 
 * Reference:
 *  https://leetcode.com/problems/zuma-game/discuss/97010/%22short%22-java-solution-beats-98
 */
package com.zea7ot.leetcode.lvl6.lc0488;

public class SolutionApproach2Backtrack {
    private static final int MAX_COUNT = 6;
    
    public int findMinStep(String board, String hand) {
        
        final int L = hand.length();
        final char[] CHS = hand.toCharArray();
        int[] freq = new int[26];
        for(int i = 0; i < L; ++i){
            ++freq[CHS[i] - 'A'];
        }
        
        int ans = backtrack(board + "#", freq);
        return ans == MAX_COUNT ? -1 : ans;
    }
    
    private int backtrack(String str, int[] freq){
        str = removeConsecutive(str);
        if(str.equals("#")) return 0;
        int res = MAX_COUNT, need = 0;
        for(int i = 0, j = 0; j < str.length(); ++j){
            if(str.charAt(i) == str.charAt(j)) continue;
            need = 3 - (j - i);
            if(freq[str.charAt(i) - 'A'] >= need){
                freq[str.charAt(i) - 'A'] -= need;
                res = Math.min(res, need + backtrack(str.substring(0, i) + str.substring(j), freq));
                freq[str.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        
        return res;
    }
    
    private String removeConsecutive(String board){
        final int L = board.length();
        for(int i = 0, j = 0; j <= L; ++j){
            if(j < L && board.charAt(j) == board.charAt(i)) continue;
            if(j - i >= 3) 
                return removeConsecutive(board.substring(0, i) + board.substring(j));
            else i = j;
        }
        
        return board;
    }
}