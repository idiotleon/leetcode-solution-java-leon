/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * 
 *  if it is required to remove all k-in-a-row duplicates in a string?
 *  (for more-than-k-in-a-row, to remove only first `k` duplicates)?
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/discuss/294964/JavaPython-3-three-easy-iterative-codes-w-brief-explanation-analysis-and-follow-up.
 */
package com.zea7ot.leetcode.lvl2.lc1047.followup;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionApproach0Stacks {
    public String removeDuplicates(String str, int k) {
        Deque<Character> charStack = new ArrayDeque<Character>();
        Deque<Integer> countStack = new ArrayDeque<Integer>();

        for (char ch : str.toCharArray()) {
            if (charStack.isEmpty() || charStack.peek() != ch) {
                charStack.push(ch);
                countStack.push(1);
            } else if (countStack.peek() + 1 < k) {
                countStack.push(countStack.pop() + 1);
            } else {
                charStack.pop();
                countStack.pop();
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char ch : charStack) {
            int count = countStack.pop();
            while (count-- > 0)
                builder.append(ch);
        }

        return builder.reverse().toString();
    }
}