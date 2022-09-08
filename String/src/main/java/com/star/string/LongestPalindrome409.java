package com.star.string;

import org.junit.Test;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-17-2021 14:24
 */
public class LongestPalindrome409 {

    /**
     * 两种情况
     * 回文串里每种字符都出现了偶数次
     * 除了奇数长度的回文串的时候最中间的那个字符可以出现奇数次。 比如回文串 abba，每个字符都出现了偶数次
     */
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {// 加入数组中统计次数
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            // 字符出现的次数最多用偶数次
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }


    @Test
    public void longestPalindromeTest() {
        String s = "abcba";
        System.out.println(longestPalindrome(s));
    }
}
