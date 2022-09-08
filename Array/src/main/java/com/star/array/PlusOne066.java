package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-04-2021 22:19
 */
public class PlusOne066 {

    /**
     * 数组每位都是single digit，所以只能是0-9的个位数，整个数没有leading zero，意思就是数组第一个数必非0
     * 注意整型溢出
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                // 直接结束for循环
                return digits;
            }
            // 最后为9，变为0，前一位进位，i--，digits[i]++就执行了进位
            digits[i] = 0;
        }
        // 跳出for循环，说明数字全部是9，进一位
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    @Test
    public void plusOneTest() {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
