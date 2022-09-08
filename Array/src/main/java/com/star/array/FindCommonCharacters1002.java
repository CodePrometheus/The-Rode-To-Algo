package com.star.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * @Author: zzStar
 * @Date: 03-05-2021 09:16
 */
public class FindCommonCharacters1002 {

    /**
     * 求每个字符串之间字符数量的交集
     * 数组res的下标i表示是哪个字符，用res[i]表示该字符出现的次数
     */
    public List<String> commonChars(String[] a) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c : a[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < a.length; i++) {
            int[] tem = new int[26];
            for (char c : a[i].toCharArray()) {
                tem[c - 'a']++;
            }
            // 存储字符 c 在所有字符串中出现次数的最小值
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], tem[j]);
            }
        }
        // 转换
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                for (int j = 0; j < res[i]; j++) {
                    list.add(((char) ('a' + i) + ""));
                }
            }
        }
        return list;
    }

    /**
     * 桶计数：
     * <p>
     * 创建二维数组map[A.length][26]
     * <p>
     * 一维下标分别代表字母，0-a, 1-b, ... , 25-z
     * <p>
     * 二维下标代表对应字母出现了多少次
     * <p>
     * 如：["bella","label","roller"]最后计数对应为
     * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
     * [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0]
     * <p>
     * 最后从上往下纵向对比取最小值min，然后把对应字母重复min次插入List中
     * <p>
     * 比如上例下标0从上往下取值分别是[1,1,0],最小值为0，说明a最终出现0次，
     * 同理，下标4(对应e)分别为[1,1,1],最小值为1,e最终出现1次
     * 同理，下标11(l)出现2次
     * 其他均为0次
     * 结果为 e,l,l
     */
    public List<String> commonChars2(String[] a) {
        int[][] map = new int[a.length][26];
        for (int i = 0; i < a.length; i++) {
            for (char c : a[i].toCharArray()) {
                map[i][c - 'a'] = map[i][c - 'a'] + 1;
            }
        }
        List<String> ans = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < a.length; j++) {
                min = Math.min(map[j][i], min);
            }
            for (int k = 0; k < min; k++) {
                ans.add(String.valueOf((char) ('a' + i)));
            }
        }
        return ans;
    }

    @Test
    public void commonCharsTest() {
        String[] b = {"bella", "label", "roller"};
        System.out.println(commonChars(b));
        System.out.println(commonChars2(b));
    }
}
