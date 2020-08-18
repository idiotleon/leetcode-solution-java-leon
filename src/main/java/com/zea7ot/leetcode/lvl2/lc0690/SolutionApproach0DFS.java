/**
 * https://leetcode.com/problems/employee-importance/
 * 
 * Time Complexity:     O(V + E) ~ O()
 * Space Complexity:    O(V + E) ~ O()
 * 
 * References:
 *  https://leetcode.com/problems/employee-importance/discuss/112587/Java-HashMap-bfs-dfs
 */
package com.zea7ot.leetcode.lvl2.lc0690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionApproach0DFS {
    public int getImportance(List<FakeEmployee> employees, int id) {
        Map<Integer, FakeEmployee> map = new HashMap<Integer, FakeEmployee>();
        for(FakeEmployee employee: employees){
            map.put(employee.id, employee);
        }
        return getImportance(id, map);
    }
    
    private int getImportance(int rootId, Map<Integer, FakeEmployee> map){
        FakeEmployee root = map.get(rootId);
        int total = root.importance;
        for(int subordinate : root.subordinates){
            total += getImportance(subordinate, map);
        }
        return total;
    }
}