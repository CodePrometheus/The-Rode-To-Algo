package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个整数num，请你找出同时满足下面全部要求的两个整数：
 * <p>
 * 两数乘积等于 num + 1或num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 * 示例 2：
 * <p>
 * 输入：num = 123
 * 输出：[5,25]
 * 示例 3：
 * <p>
 * 输入：num = 999
 * 输出：[40,25]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-divisors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-01-2021 22:32
 */
public class ClosestDivisors1362 {

    /**
     * 以较大数 divisor = num + 2 的平方根开始，递减找到最接近的小因数，
     * (num + 2) % i == 1，则 (num + 1) % i == 0，所以 (num + 2) % i 为0或1时都满足条件：
     * 当余数为0时，大因数为 (num + 2) / i，
     * 当余数为1时，大因数为 (num + 1) / i，当且仅当 i != 1 时，有(num + 1) / i == (num + 2) / i，余数1会被整型忽略，
     * i == 1 的情况：
     * num == 1 时，i == 1，此时可直接返回[1, 2]，可以取 divisor = num + 1，使绝对差最小；
     * num > 1 时，divisor >= 2 + 2，i可能为1的情况是divisor为质数，但除2以外的质数都是奇数，divisor - 1（即 num + 1）为偶数，
     * 至少有[2, (num + 1) / 2]成立，i不会递减到1。
     */
    public int[] closestDivisors(int num) {
        int divisor = num == 1 ? num + 1 : num + 2;
        int i = (int) Math.sqrt(divisor);
        while (divisor % i > 1) {
            i--;
        }
        return new int[]{i, divisor / i};
    }

    @Test
    public void closestDivisorsTest() {
        int num = 20;
        System.out.println(Arrays.toString(closestDivisors(num)));
    }
}
