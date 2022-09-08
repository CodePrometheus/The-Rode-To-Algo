package com.star.string;

import org.junit.Test;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * @Author: zzStar
 * @Date: 02-19-2021 20:16
 */
public class RepeatedSubstringPattern459 {

    public boolean repeatedSubstringPattern(String s) {
        // i为子串长度，这步类似于寻找s.length的因数
        for (int i = 1; i < s.length(); ++i) {
            // 如果i为s.length，再判断该长度的子串是否可以多次构成原字符串
            if (s.length() % i == 0) {
                // t为长度为i的子串
                String t = s.substring(0, i);
                boolean flag = true;
                // 将长度为i的子串t与字符串s比较，比较的间隔为i
                for (int j = i; j + i <= s.length(); j += i) {
                    // substring() 方法用于提取字符串中介于两个指定下标之间的字符
                    if (!t.equals(s.substring(j, j + i))) {
                        // 如果构成失败，return false
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void repeatedSubstringPatternTest() {
        String s = "abcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}
