package com.leetcode.topic1_50;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50
 * @Description : TODO
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
