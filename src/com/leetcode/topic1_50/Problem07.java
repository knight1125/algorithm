package com.leetcode.topic1_50;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
//
//
// 示例 1：
//
//
//输入：x = 123
//输出：321
//
//
// 示例 2：
//
//
//输入：x = -123
//输出：-321
//
//
// 示例 3：
//
//
//输入：x = 120
//输出：21
//
//
// 示例 4：
//
//
//输入：x = 0
//输出：0
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
// Related Topics 数学
// 👍 2792 👎 0
/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50
 * @Description : 整数反转
 * @Create on : 2021/5/9 10:37
 **/
public class Problem07 {
    public static void main(String[] args) {
        System.out.println(new Problem07().reverse2(-123));
    }


    /**
     * 法一，字符串翻转 性能极差
     * @return
     */
    public int reverse(int x) {
        try {
            if (x < 0) {
                String s = String.valueOf(x);
                String preReverseStr = s.substring(1);
                String afterReverse = new StringBuilder(preReverseStr).reverse().toString();
                return Integer.valueOf("-" + afterReverse);
            } else {
                return Integer.valueOf(new StringBuilder().append(x+ "").reverse().toString());
            }
        } catch (NumberFormatException e) {
            // 处理溢出
            return 0;
        }
    }

    public int reverse2(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        // 处理溢出
        return (int)n==n? (int)n:0;
    }
}
