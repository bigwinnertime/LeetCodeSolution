package org.bigwinner.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: bigwinner
 * @date: 2021/2/22 下午7:46
 * @version: 1.0.0
 * @description: 买卖水果钱(huawei)
 */
public class SaleFruits {
    
    public int main(int[] m, int[] n, int amount) {
        // 保存水果利润
        List<Integer> resList = new ArrayList<>();
        // 保存排序好的水果利润
        List<Integer> priceList = new ArrayList<>();
        Integer maxPrice = 0, baseMoney = 0;
        Map<Integer, Integer> priceMap = new HashMap<>(7);
        int i = 0, k = 0, res = 0;

        while (i < m.length - 1) {
            // 1.求每种水果的利润
            priceMap.put(n[i] - m[i], i);
            resList.add(n[i] - m[i]);
            // 2.对水果的利润排序
            for (int j = 0; j < resList.size(); j ++) {
                if (j + 1 < resList.size()) {
                    maxPrice = Math.max(resList.get(j), resList.get(j + 1));
                } else {
                    maxPrice = Math.max(resList.get(j), maxPrice);
                }
                priceList.add(maxPrice);
                resList.remove(maxPrice);
            }
            i++;
        }
        // 3.找出本金能囊括的前n利润大的水果
        while (k < priceList.size()) {
            if (baseMoney >= amount) return res;
            baseMoney += priceMap.get(priceList.get(k)) + priceMap.get(priceList.get(k+1));
            res += n[priceMap.get(priceList.get(k))];
            k ++;
        }
        return res;
    }
}
