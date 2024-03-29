/**
 * https://leetcode.com/problems/distribute-candies-to-people/
 * 
 * Time Complexity:     O(lg(`candies`))
 * Space Complexity:    O(`numPeople`)
 * 
 * `people[give % numPeople]`: to calculate the value of each column
 * `min(candies, give + 1)`: to add the last remaining candies
 * 
 * References:
 *  https://leetcode.com/problems/distribute-candies-to-people/discuss/323314/JavaPython3-Easy-code-w-explanation-and-analysis.
 */
package com.idiotleon.leetcode.lvl2.lc1103;

public class SolutionApproach0LinearScan {
    public int[] distributeCandies(int candies, int numPeople) {
        int[] distributions = new int[numPeople];
        for (int give = 0; candies > 0; candies -= give)
            distributions[give % numPeople] += Math.min(candies, ++give);

        return distributions;
    }
}