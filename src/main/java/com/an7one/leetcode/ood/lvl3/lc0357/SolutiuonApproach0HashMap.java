/**
 * https://leetcode.com/problems/apply-discount-every-n-orders/
 * 
 * Time Complexity:     O()
 * Space Complexity:    O()
 * 
 * References:
 *  https://leetcode.com/problems/apply-discount-every-n-orders/discuss/516990/JavaPython-3-HashMapDictionary
 */
package com.an7one.leetcode.ood.lvl3.lc0357;

import java.util.HashMap;
import java.util.Map;

public class SolutiuonApproach0HashMap {
    private final int DISCOUNT;
    private final int N;
    private final Map<Integer, Integer> CATALOG;
    private int count;

    public SolutiuonApproach0HashMap(int n, int discount, int[] products, int[] prices) {
        this.N = n;
        this.DISCOUNT = discount;
        this.CATALOG = new HashMap<Integer, Integer>();

        for (int i = 0; i < products.length; ++i)
            CATALOG.put(products[i], prices[i]);
    }

    public double getBill(int[] product, int[] amount) {
        double total = 0.0;
        for (int i = 0; i < product.length; ++i)
            total += CATALOG.get(product[i]) * amount[i];
        return total * (++count % N == 0 ? 1 - DISCOUNT / 100d : 1);
    }
}