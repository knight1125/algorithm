package com.interview.array;

import java.util.Arrays;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.interview.array
 * @Description :  从数组中,选择一个数字,将组数组中的数字顺序调整为 小于他 等于他 大于他;
 *
 *   快速排序也用到了这个思想
 * @Create on : 2021/5/29 16:26
 **/
public class T8 {

    /**
     * @param pos 所选取的数字的位置
     */
    private void adjustArray(int[] array, int pos) {
        if (pos >= array.length) return;

        int pivot = array[pos];
        int begin = 0;
        int end = array.length - 1;

        // 将大于固定数字的移动到数组右侧
        while (begin <= end ) {
            if (array[begin] >= pivot) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
                end--;
            } else {
                begin++;
            }
        }

        // 将大于固定数字的移动到数组右侧
        begin = end;
        end = array.length -1;
        while (begin <= end ) {
            if (array[begin] > pivot) {
                int temp = array[begin];
                array[begin] = array[end];
                array[end] = temp;
                end--;
            } else {
                begin++;
            }
        }

    }


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,6,4,6,4,1,7,2,3};
        new T8().adjustArray(arr,5);
        Arrays.stream(arr).forEach(System.out::println);

    }
}
