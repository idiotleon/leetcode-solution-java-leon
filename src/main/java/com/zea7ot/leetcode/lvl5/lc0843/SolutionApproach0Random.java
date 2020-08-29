/**
 * https://leetcode.com/problems/guess-the-word/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://www.youtube.com/watch?v=8_86eMEoKeE
 *  https://github.com/wisdompeak/LeetCode/tree/master/Others/843.Guess-the-Word
 */
package com.zea7ot.leetcode.lvl5.lc0843;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SolutionApproach0Random {
    public void findSecretWord(String[] wordlist, FakeMaster master) {
        for (int i = 0; i < 10; ++i) {
            final int N = wordlist.length;
            int idx = new Random().nextInt(N);
            String str = wordlist[idx];
            int count = master.guess(str);
            if (count == 6)
                return;

            List<String> list = new ArrayList<>();
            for (String word : wordlist) {
                if (word.equals(str))
                    continue;
                if (matchCount(str, word) == count)
                    list.add(word);
            }

            wordlist = list.toArray(new String[0]);
        }
    }

    private int matchCount(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < 6; ++i)
            if (str1.charAt(i) == str2.charAt(i))
                ++count;

        return count;
    }
}