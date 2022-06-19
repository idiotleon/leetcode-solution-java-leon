package com.an7one.leetcode.lvl2.lc0690;

import com.an7one.util.Constant;

import java.util.*;

/**
 * @author: Leon
 * <a href="https://leetcode.com/problems/employee-importance/">Description</a>
 *
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 *
 * References:
 *  <a href="https://leetcode.com/problems/employee-importance/discuss/112587/Java-HashMap-bfs-dfs">...</a>
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class SolutionApproach0BFS {
    public int getImportance(List<FakeEmployee> employees, int id) {
        int ans = 0;
        Map<Integer, FakeEmployee> map = new HashMap<>();
        for(FakeEmployee employee: employees){
            map.put(employee.id, employee);
        }
        
        Deque<FakeEmployee> queue = new ArrayDeque<>();
        queue.offer(map.get(id));
        while(!queue.isEmpty()){
            FakeEmployee top = queue.removeFirst();
            ans += top.importance;
            for(int subordinate : top.subordinates){
                queue.addLast(map.get(subordinate));
            }
        }
        
        return ans;
    }
}