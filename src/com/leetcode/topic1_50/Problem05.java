package com.leetcode.topic1_50;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3619 👎 0
/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50
 * @Description : 最长的回文子串
 * @Create on : 2021/5/9
 **/
public class Problem05 {
    public static void main(String[] args) {
        System.out.println(new Problem05().longestPalindrome2("babad").equals("bab"));
    }
    /**
     * 法一： 动态规划， 状态函数  时间O(n2) 空间O(n2)
     * p(i,i) = true;
     * p(i,i+1) = (Si == Si+1)
     * p(i,j) = (Si == Sj) && P(i+1,j-1)
     */
    public  String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int length = s.length();
        // 最长串的长度
        int maxLength = 1;
        // 最长串的左边界
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        // 注意循环条件，从短的遍历到长的
        for (int len = 2; len <= length; len++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < length; i++) {
                // len = j - i + 1;
                int j = len + i - 1;
                if (j >= length) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i + 1 < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    private  int lo, maxLen;
    /**
     *  法二：从中间往两边扩展
     */
    public  String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // 同一位置开始扩
            extendPalindrome(s,i,i);
            // 差一位置开始扩
            extendPalindrome(s,i,i + 1);
        }
        return s.substring(lo,lo + maxLen);
    }

    private  void extendPalindrome(String s, int left, int right ) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        // 上面的循环，在合适的位置，左右再次向两边扩展了一下，所以注意此处边界
        if (maxLen < right - left - 1) {
            maxLen = right -left - 1;
            lo = left + 1;
        }
    }
}
