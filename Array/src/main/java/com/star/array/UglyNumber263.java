package com.star.array;

import org.junit.Test;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * 示例 3：
 * <p>
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数7 。
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 *
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-10-2021 22:11
 */
public class UglyNumber263 {

    /**
     * 对能被2,3,5整除的数不断除2,3,5，最后剩1就是，剩0就不是，除2可以用位运算替换
     * 0 和负数都不是丑数。因为 0 的因数没有 2、3、5；而负数的因数中一定有一个负数，所以因数不仅仅是 2、3、5。
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    /**
     * 递归
     */
    public boolean isUgly2(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        if (n % 2 == 0) {
            return isUgly2(n / 2);
        } else if (n % 3 == 0) {
            return isUgly2(n / 3);
        } else if (n % 5 == 0) {
            return isUgly2(n / 5);
        } else {
            return false;
        }
    }

    public boolean isUgly3(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }


    @Test
    public void isUglyTest() {
        int n = 30;
        System.out.println(isUgly(n));
        System.out.println(isUgly2(n));
        System.out.println(isUgly3(n));
    }
}
