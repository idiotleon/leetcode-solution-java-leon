package com.idiotleon.leetcode.lvl4.lc0621;

import com.idiotleon.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/task-scheduler/
 * <p>
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * <p>
 * References:
 * https://leetcode.com/problems/task-scheduler/discuss/104501/Java-PriorityQueue-solution-Similar-problem-Rearrange-string-K-distance-apart
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach1MaxHeap {
    public int leastInterval(char[] tasks, int n) {
        // sanity check
        if (tasks == null || tasks.length == 0)
            return 0;

        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        Queue<Task> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Task task = new Task(entry.getKey(), entry.getValue());
            maxHeap.offer(task);
        }

        int ans = 0;
        // to literally simulate the CPU cycles running tasks
        while (!maxHeap.isEmpty()) {
            int k = n + 1;
            List<Task> list = new ArrayList<>();
            while (k > 0 && !maxHeap.isEmpty()) {
                Task top = maxHeap.poll();
                top.count--;
                list.add(top);
                k--;
                ans++;
            }

            for (Task task : list) {
                if (task.count > 0) {
                    maxHeap.add(task);
                }
            }

            if (maxHeap.isEmpty())
                break;
            ans = ans + k;
        }

        return ans;
    }

    private static class Task {
        @SuppressWarnings("unused")
        private final char ch;
        private int count;

        protected Task(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}