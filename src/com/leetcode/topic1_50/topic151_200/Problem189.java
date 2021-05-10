package com.leetcode.topic1_50.topic151_200;

import java.util.Arrays;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50.topic151_200
 * @Description : 将数组向右移动k位  (核心移动元素，对应翻转！！！数据结构书上有的题)
 * @Create on : 2021/5/10 20:54
 **/
public class Problem189 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        new Problem189().rotate(ints,2);
        Arrays.stream(ints).forEach( System.out::println);
    }


    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tem = nums[start];
            nums[start] = nums[end];
            nums[end] = tem;
            start++;
            end--;
        }
    }

}
