package com.star.string;

import org.junit.Test;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * num1 和num2的长度都小于 5100
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 *
 * @Author: zzStar
 * @Date: 02-19-2021 19:39
 */
public class AddStrings415 {

    /**
     * 双指针 字符串加法、链表加法以及二进制加法之类的同理
     * 设定 i，j 两指针分别指向 num1，num2 尾部
     * 计算进位： 计算 carry = tmp // 10，代表当前位相加是否产生进位；
     * 添加当前位： 计算 tmp = n1 + n2 + carry，并将当前位 tmp % 10 添加至 res 头部；
     * 索引溢出处理： 当指针 i或j 走过数字首部后，给 n1，n2 赋值为 00，相当于给 num1，num2 中长度较短的数字前面填 00，以便后续计算。
     * 当遍历完 num1，num2 后跳出循环，并根据 carry 值决定是否在头部添加进位 11，最终返回 res 即可。
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            // 要获取int值，就要减去‘0’才可以
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    @Test
    public void addStringsTest() {
        String num1 = "123";
        String num2 = "458";
        System.out.println(addStrings(num1, num2));
    }

}
