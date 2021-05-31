package com.sort;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.quickSortRecursion
 * @Description : 快速排序, 明天计划, TopK , 堆排序;
 * @Create on : 2021/6/1 00:06
 **/
public class QuickSort implements Sort {


    @Override
    public void sort(Comparable[] arr) {
        quickSortRecursion(arr,0,arr.length -1);
    }

    /**
     快速排序(递归) 边界均闭
     */
    private void quickSortRecursion(Comparable[] arr, int low, int high) {
        if (low < high) {
            int index = partitionAndChange(arr, low,high);
            quickSortRecursion(arr,low,index - 1);
            quickSortRecursion(arr,index + 1, high);
        }
    }

    private int partitionAndChange(Comparable[] arr, int low, int high) {
        Comparable temp = arr[low];
        while (low < high) {
            while (low <high && arr[high].compareTo(temp)>=0) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low].compareTo(temp) <= 0) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        Sort quickSort = new QuickSort();
        quickSort.printResult();

    }
}
