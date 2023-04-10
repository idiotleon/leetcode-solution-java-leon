/**
 * https://leetcode.com/problems/stickers-to-spell-word/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * 
 * 
 * References:
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution/110545
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution/110544
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution/110543
 *  https://leetcode.com/problems/stickers-to-spell-word/discuss/108333/Rewrite-of-contest-winner's-solution
 *  https://youtu.be/FLbqgyJ-70I?t=11301
 */
package com.idiotleon.leetcode.lvl5.lc0691;

import java.util.Arrays;

public class SolutionApproach0DP1Dimen {
    public int minStickers(String[] stickers, String target) {
        final int N = target.length(), RANGE = 1 << N;
        int[] dp = new int[RANGE];
        Arrays.fill(dp, 1, RANGE, 16);
        // dp[0] = 0;
        
        for(int now = 0; now < RANGE; ++now){
            if(dp[now] == 16) continue;
            for(String sticker : stickers){
                int next = now;
                for(char ch : sticker.toCharArray()){
                    for(int idx = 0; idx < N; ++idx){
                        int pos = 1 << idx;
                        if(target.charAt(idx) == ch && (pos & next) == 0){
                            next |= pos;
                            break;
                        }
                    }
                }

                dp[next] = Math.min(dp[next], dp[now] + 1);
            }
        }
        
        return dp[RANGE - 1] == 16 ? -1 : dp[RANGE - 1];
    }
}