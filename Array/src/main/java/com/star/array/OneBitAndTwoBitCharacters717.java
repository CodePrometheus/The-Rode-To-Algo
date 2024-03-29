package com.star.array;

import org.junit.Test;

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10或11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例2:
 * <p>
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-23-2021 13:37
 */
public class OneBitAndTwoBitCharacters717 {

    public boolean isOneBitCharacter(int[] bits) {
        int start = 0;
        while (start < bits.length - 1) {
            if (bits[start] == 0) {
                start++;
            } else {
                start += 2;
            }
        }
        // 最后跳的步长
        return start == bits.length - 1;
    }

    /**
     * 只与最后一个元素0的前面的连续1的个数有关系。
     * 如果 1 的个数为偶数个，那么最后一位是一比特字符，如果 1 的个数为奇数个，那么最后一位不是一比特字符。
     * 贪心
     */
    public boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }


    @Test
    public void isOneBitCharacterTest() {
        int[] bits = {1, 1, 1, 0};
        int[] b2 = {1, 0, 0};
        System.out.println(isOneBitCharacter(bits));
        System.out.println(isOneBitCharacter(b2));
        System.out.println(isOneBitCharacter2(b2));
    }
}
