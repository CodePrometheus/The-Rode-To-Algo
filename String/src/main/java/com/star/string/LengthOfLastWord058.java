package com.star.string;

import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 02-16-2021 21:22
 */
public class LengthOfLastWord058 {

    /**
     * 先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度
     */
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    @Test
    public void lengthOfLastWordTest() {
        String s = "hello leetcode";
        System.out.println(lengthOfLastWord(s));
    }
}
