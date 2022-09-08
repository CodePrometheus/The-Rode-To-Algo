package com.star.string;

import org.junit.Test;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * @Author: zzStar
 * @Date: 02-18-2021 22:14
 */
public class RansomNote383 {

    /**
     * 首先，是判定magazine的长度是否小于ransom，如果小于那么一定是false；
     * 之后，它实际上是遍历了ransom当中的所有字符，然后在caps中保存的并非是magazine中每类字母的个数，
     * 而是在对应当前字符c的magazine中每类字母应该遍历的起始位置，如果index == -1则表示在magazine中从caps指定的遍历位置开始没有找到一样的字符，则输出false
     */
    public boolean canConstruct(String ransom, String magazine) {
        if (magazine.length() < ransom.length()) {
            return false;
        }
        int caps[] = new int[26];
        for (char c : ransom.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1) {
                return false;
            }
            caps[c - 97] = index + 1;
        }
        return true;
    }

    @Test
    public void canConstructTest() {
        String ran = "abb";
        String mag = "abbab";
        System.out.println(canConstruct(ran, mag));
    }
}
