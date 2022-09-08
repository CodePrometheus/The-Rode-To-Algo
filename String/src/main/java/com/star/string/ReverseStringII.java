package com.star.string;

import org.junit.Test;

/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起2k 个字符的前 k 个字符进行反转。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-20-2021 23:42
 */
public class ReverseStringII {

    /**
     * 每隔k个反转k个，末尾不够k个时全部反转
     * 双指针
     */
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // 每2k个元素为一组进行反转
        for (int i = 0; i < n; i += 2 * k) {
            int left = i;
            // 判断下标是否越界
            int right = (i + k - 1 < n) ? i + k - 1 : n - 1;
            while (left <= right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        String str = new String(ch);
        return str;
    }

    @Test
    public void reverseStrTest() {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
