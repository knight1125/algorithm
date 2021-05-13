package com.sort;

import java.util.Arrays;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.sort
 * @Description : 选择排序  （从未排序的序列中，找到最小元素所在的位置，放在有序序列的尾部）
 * @Create on : 2021/5/13 19:53
 *
 * 1、时间复杂度：没有所谓最好最坏情况
 *    1） 比较：n -1 + n -2 + ...+ 1 = n(n -1)/2
 *    2） 交换：n -1
 * 2、 空间复杂度 O（1）
 * 3、稳定性： 不稳定（长距离的交换可能导致不稳定）
 **/
public class SelectSort implements Sort {

    @Override
    public  void sort(Comparable[] arr) {

        // 这里写arr.length 依然可以
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // 交换 ,这里可以不判断 minIndex != i
            Comparable tem = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tem;

            System.out.println("第" + i + "轮排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        Comparable[] comparables = selectSort.prpareData();
        System.out.println("排序前：" + Arrays.toString(comparables));
        selectSort.sort(comparables);
        System.out.println("排序后：" + Arrays.toString(comparables));
    }
}
