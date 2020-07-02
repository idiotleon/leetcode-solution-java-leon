/**
 * https://leetcode.com/problems/employee-importance/
 * 
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 * 
 * References:
 *  https://leetcode.com/problems/employee-importance/discuss/112587/Java-HashMap-bfs-dfs
 */
package com.zea7ot.lc.lvl2.lc0690;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SolutionApproach0BFS {
    public int getImportance(List<FakeEmployee> employees, int id) {
        int ans = 0;
        Map<Integer, FakeEmployee> map = new HashMap<Integer, FakeEmployee>();
        for(FakeEmployee employee: employees){
            map.put(employee.id, employee);
        }
        
        Queue<FakeEmployee> queue = new LinkedList<FakeEmployee>();
        queue.offer(map.get(id));
        while(!queue.isEmpty()){
            FakeEmployee top = queue.poll();
            ans += top.importance;
            for(int subordinate : top.subordinates){
                queue.offer(map.get(subordinate));
            }
        }
        
        return ans;
    }
}