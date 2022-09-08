package com.star.string;

import org.junit.Test;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @Author: zzStar
 * @Date: 02-14-2021 23:18
 */
public class LongestCommonPrefix014 {

    /**
     * startswith
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 公共前缀比所有字符串<=，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            // 字符串以指定的值开头,则 startswith() 方法返回 True,否则返回 False
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                // 公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    /**
     * 一个类似的解法 返回指定字符在字符串中第一次出现处的索引
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 以第一个字符串为最大公共前缀，从第二个字符串开始判断是否存在该前缀，不存在时将字符串从后开始缩减直到存在，然后挨个遍历字符串数组。
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    @Test
    public void longestCommonPrefixTest() {
        String[] strs = {"pig", "pig", "pig"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
    }
}
