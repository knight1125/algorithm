package com.sort;

import java.util.Arrays;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.sort
 * @Description : 冒泡排序
 * @Create on : 2021/5/13 19:22
 *
 *  1. 时间复杂度（针对优化后）
 *    1） 最好: O(n)
 *       1） 比较的次数 n -1
 *       2) 交换 0
 *    2） 最坏 （完全逆序）N2
 *       1） 比较 （n - 1 + n -2 + ... + 1） =  n*(n -1)/2
 *       2) 交换次数 = 比较次数
 *    3） 平均情况 (N2)
 *       1. 平均的定义因具体的应用场景而定， 简单的认为每一种情况出现的概率相同
 *       2. n 个 元素 的全排列是 n ！, 非常复杂
 *       3. 方法大概看一下时间复杂度
 *          有序元素对，逆序元素对，满有序度
 *          冒泡一次交换(相邻元素)，会使得，有序度+1，逆序度 -1；
 *          可以认为，平均情况下，逆序度为 n*(n-1)/4
 *          交换的次数为 ： n*(n -1)/4
 *          比较次数：>= 交换次数 < n(n -1)/2
 *  2. 空间复杂度 o(1)
 *  3. 稳定性： 稳定的.
 **/
public class BubbleSort implements Sort {

    @Override
    public  void sort(Comparable[] arr) {
        // n - 1 重 （大的放在后面）
        for (int i = 1; i < arr.length; i++) {
            // 假设序列就是有序的，若没有交换，跳出循环
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted= false;
                }
            }
            if (isSorted) break;
            System.out.println("第" + i + "轮排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Integer[] arr = (Integer[]) bubbleSort.prpareData();
        System.out.println("排序前：" + Arrays.toString(arr));
        bubbleSort.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
