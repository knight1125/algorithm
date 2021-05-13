package com.leetcode.topic1_50;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划
// 👍 2338 👎 0

import java.util.Arrays;
import java.util.Map;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50
 * @Description : 接雨水， 困难题 ， dp
 * @Create on : 2021/5/12 22:07
 **/
public class Problem42 {

    public static void main(String[] args) {
        int[] test = {4,2,3};
        System.out.println(new Problem42().trap4(test));
    }



    // 法一： 按行求解， 遇到小于当前高度i的，就把tem + 1, 遇到高度>= 当前高度的， 最终值加上tem ，且tem清零。
    // 注意，最左右两边的水会流掉， 所以，第一次遇到高度 >= i后，才能开始计算
    // 超出时间限制，过不了所有用例
    public int trap(int[] height) {
        int max = getMaxHeight(height);
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int tem = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    tem++;
                }
                if (height[j] >= i) {
                    sum = sum +  tem;
                    tem =0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMaxHeight(int[] height) {
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
            }
        }
        return maxHeight;
    }


    /**
     * 法二： 按行求解
     * @param height
     * @return
     */
    public int trap2(int[] height) {

        return 0;

    }

    /**
     * 动态规划
     * 状态转移方程 ：
     *  1. 当前墙左边的最高高度 =  Max（左边墙的高度， 左边墙的左边的最高高度）
     *     max_left(i) = Max(max_left(i -1), height(i - 1))
     *  2. 右边墙的最高高度同理
     *     max_right(i) = Max(max_right(i + 1), height(i + 1))
     *
     *  当前位置的雨水数= 左右两边的最高的最小值 - 当前高度
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(max_left[i],max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 双指针, 动态规划的优化
     *  两边让中间逼近
     *  较小者有机会往中间逼近，知道相遇
     * @param A
     * @return
     */
    public int trap4(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int l = 0;
        int r = A.length - 1;
        while (l < r && A[l] <= A[l+1]) {
            l++;
        }
        while (l < r && A[r] <= A[r -1]){
            r--;
        }
        int sum = 0;
        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                while (l < r && left >= A[++l]) {
                    sum += (left - A[l]);
                }
            } else {
                while (l < r && right >= A[--r]) {
                    sum += (right - A[r]);
                }
            }
        }
        return sum;
    }
}
