@author: Leon
References:
    https://www.youtube.com/watch?v=FLbqgyJ-70I
    https://docs.google.com/presentation/d/1OeA0rsnOrklarLM5G2tHHJ6EE37HpRqD7KedzOqkihk/edit?usp=sharing
    https://github.com/huanminwu/LeetCode/blob/master/LeetCode.xlsx


### Dynamic Programming
## Templates
# 1. Basic Type i - in the sequence/order of time
    https://youtu.be/FLbqgyJ-70I?t=508

2   0198    https://leetcode.com/problems/house-robber/

3   0213    https://leetcode.com/problems/house-robber-ii/
3   0276    https://leetcode.com/problems/paint-fence/
3   0376    https://leetcode.com/problems/wiggle-subsequence/
3   0487    https://leetcode.com/problems/max-consecutive-ones-ii/
3   0931    https://leetcode.com/problems/minimum-falling-path-sum/

4   0265    https://leetcode.com/problems/paint-house-ii/
4   0309    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
4   1186    https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
4   1289    https://leetcode.com/problems/minimum-falling-path-sum-ii/

5   0123    https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/


# to do or not to do
    https://youtu.be/FLbqgyJ-70I?t=1944

3   0487    https://leetcode.com/problems/max-consecutive-ones-ii/

4   1186    https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/



# 2. Basic Type ii - in the sequence/order of time - complicated
    https://youtu.be/FLbqgyJ-70I?t=2607

3   0300    https://leetcode.com/problems/longest-increasing-subsequence/

4   0516    https://leetcode.com/problems/longest-palindromic-subsequence/
4   0673    https://leetcode.com/problems/number-of-longest-increasing-subsequence/
4   1043    https://leetcode.com/problems/partition-array-for-maximum-sum/
4   1092    https://leetcode.com/problems/shortest-common-supersequence/
4   1105    https://leetcode.com/problems/filling-bookcase-shelves/



# 3. 双序列型
    https://youtu.be/FLbqgyJ-70I?t=3771

4   0097    https://leetcode.com/problems/interleaving-string/
4   0727    https://leetcode.com/problems/minimum-window-subsequence/
4   1035    https://leetcode.com/problems/uncrossed-lines/



# 4. 第1类区间型DP
    https://youtu.be/FLbqgyJ-70I?t=5449
    给出一个序列，明确要求分割成K个连续区间，计算这些区间的某个最优性质。
    套路:
        状态定义: dp[i][k]表示针对s[1 : i]分成k个区间，此时能够得到的最优解
        搜寻最后一个区间的起始位置l，将dp[i][k]分割成dp[j - 1][k - 1]和s[j : i]两部分
        最终的结果是dp[N][K]
        e.g. x x x x x x x x x x j x x x x x i
            { dp[j - 1][k - 1] } { s[j : i] }, to find the best `j`

4   0410    https://leetcode.com/problems/split-array-largest-sum/
4   0813    https://leetcode.com/problems/largest-sum-of-averages/
4   1278    https://leetcode.com/problems/palindrome-partitioning-iii/
4   1335    https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/

6   1000    https://leetcode.com/problems/minimum-cost-to-merge-stones/



# 5. 第2类区间型DP
    https://youtu.be/FLbqgyJ-70I?t=6539
    只给出一个序列S(数组/字符串)，求一个针对这个序列的最优解。
    适用条件: 这个最优解对于序列的index而言，没有"无后效性"。即无法设计dp[i]使得dp[i]仅依赖于dp[j] (j < i)。
             但是大区间的最优解，可以依赖小区间的最优解。
    套路:
        定义dp[i][j]: 表示针对s[i : j]的子问题的求解
        千方百计将大区间的dp[i][j]向小区间的dp[i'][j']转移
            第一层循环是区间大小
            第二层循环是起始点
        最终的结果是dp[1][N]

4   0312    https://leetcode.com/problems/burst-balloons/
4   0375    https://leetcode.com/problems/guess-number-higher-or-lower-ii/
4   0516    https://leetcode.com/problems/longest-palindromic-subsequence/
4   1246    https://leetcode.com/problems/palindrome-removal/

6   1000    https://leetcode.com/problems/minimum-cost-to-merge-stones/



# 6. 背包入门

0494
1094
0956
0474
0879



# 7. 状态压缩
    https://youtu.be/FLbqgyJ-70I?t=11205

4   1125

5   0691    https://leetcode.com/problems/stickers-to-spell-word/
5   1349