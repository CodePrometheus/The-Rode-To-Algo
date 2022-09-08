package com.star.string;

import org.junit.Test;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * @Author: zzStar
 * @Date: 02-19-2021 20:08
 */
public class NumberOfSegmentsInAString434 {

    /**
     * 原地法
     * 计算单词的数量，就等同于计数单词开始的下标个数。因此，只需要定义好下标的条件，就可以遍历整个字符串，检测每个下标。
     * 定义如下：若该下标前为空格（或者为初始下标），且自身不为空格，则其为单词开始的下标。该条件可以以常数时间检测。最后，返回满足条件的下标个数。
     */
    public int countSegments(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }

    /**
     * 使用内置函数
     */
    public int countSegments2(String s) {
        // 内置的 trim 函数来移除空格
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        // \\s表示 空格,回车,换行等空白符
        // +号表示一个或多个的意思
        return trimmed.split("\\s+").length;
    }

    @Test
    public void countSegmentsTest() {
        String s = "test test , ,";
        System.out.println(countSegments(s));
        System.out.println(countSegments2(s));
    }
}
