package org.bigwinner.leetcode.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: bigwinner
 * @date: 2021/3/6 下午3:52
 * @version: 1.0.0
 * @description: 合并区间
 */
public class Merge_56 {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
     *
     */
    public static int[][] merge(int[][] intervals) {
        List<int[]> mergeList = new ArrayList<>();
        // 1.按照一维数组首元素进行升序排序
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        // 2.遍历寻找交叉的元素
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (mergeList.size() == 0 || mergeList.get(mergeList.size() - 1)[1] < L) mergeList.add(intervals[i]);
            // 直接修改元素值，进行合并，注：取最大值，防止[[1,4],[2,3]]
            else mergeList.get(mergeList.size() - 1)[1] = Math.max(mergeList.get(mergeList.size() - 1)[1], R);
//            else mergeList.get(mergeList.size() - 1)[1] = R;
//            if (intervals[i][1] > intervals[i + 1][0]) {
//                // 合并交叉的元素
//                intervals[i][1] = intervals[i + 1][1];
//                mergeList.add(intervals[i]);
//                i ++;
//            } else {
//                mergeList.add(intervals[i]);
//            }
        }
        return mergeList.toArray(new int[mergeList.size()][2]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4},{2,3},{8,10},{15,18}};
        int[][] res = merge(arr);
        for (int[] brr : res) {
            for (int elem : brr) {
                System.out.print(elem);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
