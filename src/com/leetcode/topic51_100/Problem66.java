package com.leetcode.topic51_100;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 688 👎 0

import java.util.Arrays;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic51_100
 * @Description :
 * @Create on : 2021/5/11 19:27
 **/
public class Problem66 {

    public static void main(String[] args) {
        int[] ints = {1, 9, 2, 9};

        Arrays.stream(new Problem66().plusOne(ints)).forEach(System.out::println);
    }


    /**
     * 法一：暴力求解
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        boolean isAllNight = true;
        // 判断是不是全9
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                isAllNight = false;
                break;
            }
        }
        if (isAllNight) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        boolean isFinish = false;

        while (!isFinish) {
            for (int i = digits.length - 1 ;i >= 0 ; i--) {
                if (digits[i] + 1 != 10 || i == 0) {
                    digits[i] = digits[i] + 1;
                    isFinish = true;
                    break;
                }
                digits[i] = 0;
            }
        }
        return digits;
    }
    
}
