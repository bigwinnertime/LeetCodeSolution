package org.bigwinner.Common.sort;


/**
 * @author: IT大狮兄
 * @date: 2022/1/8 下午3:33
 * @version: 1.0.0
 * @description: 手撕排序算法
 */
public class SortTotal {
    public static void swapElem(int[] target, int i, int j) {
        int temp = target[i];
        target[i] = target[j];
        target[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,12,102,23,8,56,24,78,11,100,67,54,32,15,21,18,88};
        int[] sort1 = BubbleSort.sort(arr);
        int[] sort2 = SelectSort.sort(arr);
        int[] sort3 = InsertSoft.sort(arr);
        int[] sort4 = HeapSoft.sort(arr);
        int[] sort5 = QuickSoft.sort(arr, 0, arr.length - 1);
        for (int i : sort5) {
            System.out.print(i+"\t");
        }
    }
}

/**
 * 冒泡排序
 */
class BubbleSort {
    public static int[] sort (int[] target) {
        for (int i = 0; i < target.length; i++) {
            // 后面排序好的不用再次循环 j < target.length - 1 - i
            for (int j = 1; j < target.length - i; j++) {
                // 比较相邻的元素并交换
                if (target[j-1] > target[j]) SortTotal.swapElem(target, j-1, j);
            }
        }
        return target;
    }


}

/**
 * 选择排序
 */
class SelectSort {
    public static int[] sort(int[] target) {
        int minIndex;
        for (int i = 0; i < target.length; i++) {
            // minIndex随时更新
            minIndex = i;
            // 可以理解为分为两组，i组和j组，寻找j组中最小的元素
            // 前面已排序好的不用循环 j = i + 1;
            for (int j = i + 1; j < target.length; j++) {
                // 寻找最小的元素下标
                if (target[j] < target[minIndex]) minIndex = j;
            }
            // 和已排序好的i组元素交换
            SortTotal.swapElem(target, i, minIndex);
        }
        return target;
    }
}

/**
 * 插入排序
 */
class InsertSoft {
    public static int[] sort(int[] target) {
        for (int i = 1; i < target.length; i++) {
            // temp保存待排序的值
            int temp = target[i];
            int j;
            // j从i-1的位置开始循环找到比temp小的元素的位置
            for (j = i - 1; j > 0; j--) {
                // 如果下标为j的元素比temp大，该元素需要后移
                if(target[j] > temp) target[j+1] = target[j];
                // 找到了合适的位置
                else break;
            }
            // temp放入合适的位置
            target[j+1] = temp;
        }
        return target;
    }
}

/**
 * 堆排序
 */
class HeapSoft {
    public static int[] sort(int[] target) {
        // 1. 从最后一个非叶子节点构建大顶堆
        int length = target.length;
        for (int i = length/2 - 1; i >= 0; i--) {
            buildMaxHeap(target, i, length);
        }

        // 2. 从最末尾的叶子结点与最大根节点交换位置并重构大顶堆
        for (int i = length - 1; i >= 0; i--) {
            SortTotal.swapElem(target, 0, i);
            length --;
            buildMaxHeap(target, 0, length);
        }
        return target;
    }

    /**
     * 构建大顶堆
     * @param target
     * @param i
     * @param length
     */
    private static void buildMaxHeap(int[] target, int i, int length) {
        // 临时保存当前节点
        int temp = target[i];
        // 开始构建
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 比较下一层的左右子节点，如果右节点大，则指向右节点
            if (j+1 < length && target[j+1] > target[j]) j++;
            // 如果子节点比当前节点大，则交换节点
            // 注：可能是一个一直下沉的过程，所以不能使用swap方法
            if (target[j] > temp) {
                target[i] = target[j];
                i = j;
            } else break;
        }
        target[i] = temp;
    }
}

/**
 * 快速排序
 */
class QuickSoft {
    public static int[] sort(int[] target, int start, int end) {
        if (start > end || start < 0 || end >= target.length || target.length < 1) return null;
        // 1. 找基准值，基准值：基准值左侧的数据都小于基准值，右侧的数据都大于基准值
        int index = partition(target, start, end);
        // 2. 递归基准值左右两侧的数据
        if (index > start) sort(target, start, index - 1);
        if (index < end) sort(target, index + 1, end);
        return target;
    }

    /**
     * 获取基准值
     * @param target
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] target, int start, int end) {
        // 以左边元素为基准值
        int pivot = start;
        int left = start, right = end;
        while (left < right) {
            // 找到左侧比基准值大的值
            while (left < right && target[left] < target[pivot]) left ++;
            // 找到右侧比基准值小的值
            while (left < right && target[right] > target[pivot]) right --;
            // 互换位置
            if (left < right) SortTotal.swapElem(target, left, right);
        }
        // 循环结束，交换基准值和left的位置，文成一次分区操作
        SortTotal.swapElem(target, start, left);
        return left;
    }
}
