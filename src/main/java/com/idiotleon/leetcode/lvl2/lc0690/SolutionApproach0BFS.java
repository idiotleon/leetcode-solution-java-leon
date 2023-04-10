package com.idiotleon.leetcode.lvl2.lc0690;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/employee-importance/">LC0690</a>
 * <p>
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 * <p>
 * References:
 * <a href="https://leetcode.com/problems/employee-importance/discuss/112587/Java-HashMap-bfs-dfs">LC Discussion</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public int getImportance(List<FakeEmployee> employees, int id) {
        int ans = 0;
        final Map<Integer, FakeEmployee> map = new HashMap<>();
        for (FakeEmployee employee : employees) {
            map.put(employee.id, employee);
        }

        final Deque<FakeEmployee> queue = new ArrayDeque<>();
        queue.addLast(map.get(id));
        while (!queue.isEmpty()) {
            final FakeEmployee top = queue.removeFirst();
            ans += top.importance;
            for (int subordinate : top.subordinates) {
                queue.addLast(map.get(subordinate));
            }
        }

        return ans;
    }
}