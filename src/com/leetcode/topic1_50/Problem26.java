package com.leetcode.topic1_50;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50
 * @Description : 有序数组去重，算法原地  todo  注意是有序数组
 * @Create on : 2021/5/10 19:56
 **/
public class Problem26 {

    public static void main(String[] args) {

        int[] ints1 = {1,1,2};

        System.out.println(new Problem26().removeDuplicates(ints1));
    }



    // 将不重复的移动到左边
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        // 指向有序数组末尾的后一位
        int q = 1;

        while (q < nums.length) {
            if (nums[p] == nums[q]) {
                q++;
            } else {
                nums[++p] = nums[q++];
            }
            // 如果不等，就将q的值，赋值给p的后一位

        }
        return p + 1;
    }


}
