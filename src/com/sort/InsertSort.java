package com.sort;

import java.util.Arrays;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.sort
 * @Description : 插入排序， 排好序区间，待排序区间
 * @Create on : 2021/5/13 20:22
 *
 * 1、时间复杂度：
 *  1） 完全有序：O(n)
 *      1. 比较 ：n -1  交换：0
 *  2） 最坏情况：N2
 *      1、比较： 1 + 2 + ...+ n-1
 *      2、交换 次数 = 比较次数
 *  3） 平均情况：O（n2）
 *      比较次数 > 交换次数 , < 交换的次数 + n
 *      交换次数 = 逆序度 = n*n-1/4
 *
 *  3) 空间O（1）
 *  4） 稳定性： 稳定的
 *
 **/
public class InsertSort implements Sort {

    @Override
    public void sort(Comparable[] arr) {
        // i 为待排序区间的第一个元素
        for (int i = 1; i < arr.length; i++) {
            // 有序元素的末尾
            Comparable value = arr[i];
            int j = i - 1;
            while (j >= 0 && value.compareTo(arr[j]) < 0 ) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
            System.out.println("第" + i + "轮排序：" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Sort insertSort = new InsertSort();
        insertSort.printResult();
    }
}
