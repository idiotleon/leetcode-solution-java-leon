/**
 * https://leetcode.com/problems/implement-rand10-using-rand7/
 * 
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 * 
 * Reference:
 *  https://leetcode.com/problems/implement-rand10-using-rand7/discuss/150301/Three-line-Java-solution-the-idea-can-be-generalized-to-%22Implement-RandM()-Using-RandN()%22
 *  https://leetcode.com/problems/implement-rand10-using-rand7/discuss/151567/C%2B%2BJavaPython-1.183-Call-of-rand7-Per-rand10
 *  https://leetcode.com/problems/implement-rand10-using-rand7/discuss/338395/In-depth-straightforward-detailed-explanation.-(Short-Java-solution)
 */
package com.an7one.leetcode.lvl3.lc0470;

public class SolutionApproach0Math extends FakeRand7{
    public int rand10() {
        int res = 40;
        while(res >= 40){
            res = 7 * (rand7() - 1) + (rand7() - 1);
        }
        
        return res % 10 + 1;
    }
}