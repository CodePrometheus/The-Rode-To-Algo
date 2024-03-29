package com.star.dp;

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-18-2021 22:42
 */
public class NumWaysO10II {

    /**
     * 如果第一次跳的是1级台阶，那么剩下n-1级台阶，跳法是f(n-1)
     * 如果第一次跳的是2级台阶，那么剩下n-2级台阶，跳法是f(n-2)
     * 可以得出总跳法为: f(n) = f(n-1) + f(n-2)
     * 由题意可得：没有台阶的时候f(0) = 1，只有一级台阶的时候 f(1) = 1
     * 可以发现最终得出的是一个斐波那契数列：
     *
     *             | 1, (n=0)
     *     f(n) =  | 1, (n=1)
     *             | f(n-1)+f(n-2)  (n>1,n为整数)
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    @Test
    public void numWaysTest() {
        int n = 3;
        System.out.println(numWays(3));
    }
}
