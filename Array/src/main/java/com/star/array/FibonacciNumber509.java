package com.star.array;

import org.junit.Test;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * @Author: zzStar
 * @Date: 02-12-2021 22:40
 */
public class FibonacciNumber509 {

    /**
     * 递归 效率低
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        // F(n) = F(n - 1) + F(n - 2)
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }
        // 只要记录前两个状态，所以可以优化成常数空间
        int a = 0, b = 1, c;
        // n>=3
        while (n-- > 1) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * 自顶向下的动态规划
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        int[] memo = new int[n + 1];
        // 进行备忘录的递归
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // 已经计算过了，不用再计算了
        if (memo[n] != 0) {
            return memo[0];
        }

        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * dp 数组的迭代解法
     */
    public int fib4(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化空间复杂度
     */
    public int fib5(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // 递推关系
        int pre = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }

    @Test
    public void fibTest() {
        int n = 3;
        System.out.println(fib(n));
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        System.out.println(fib4(n));
        System.out.println(fib5(n));
    }
}
