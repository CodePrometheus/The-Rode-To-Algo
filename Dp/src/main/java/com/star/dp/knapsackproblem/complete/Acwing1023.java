package com.star.dp.knapsackproblem.complete;

import org.junit.Test;

import java.util.Scanner;

/**
 * 小明手里有n元钱全部用来买书，书的价格为10元，20元，50元，100元
 * 问小明有多少种买书方案？（每种书可购买多本）
 * <p>
 * 输入格式：
 * 一个整数n，代表总共钱数。
 * <p>
 * 输出格式：
 * 一个整数，代表选择方案种数。
 * 每个物品可以选择无限个，属于完全背包，每种书可购买多本 是完全背包的变形
 * ---
 * 20
 * 2
 * ---
 * 15
 * 0
 * ---
 * 0
 * 1
 *
 * @Author: Starry
 * @Date: 09-11-2022 22:24
 */
public class Acwing1023 {
    // 设 a 数组分别为所有书的价格，接着就是一个完全背包求方案数
    // 状态表示——集合：f[i][j] 表示考虑前 i 个数字，且总数字和恰好 j 的集合下能获得的方案数
    // 状态表示——属性：因为是求方案数，故为 count，也就是和
    // 状态计算——集合划分：考虑第 i 个数选不选
    //      不选或选不了（剩余数量不够 j<a[i]）：f[i−1][j]
    //      选：f[i][j−a[i]] 首先对第i个数字进行了抉择，但是因为完全背包优化的缘故
    //      所以前一维还是 i，接着因为使用了 a[i] 的价钱，所以应该是 j−a[i]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i][j] = dp[i-1][j] + dp[i][j-v]
        int[][] dp = new int[5][n + 1];
        dp[0][0] = 1;
        int[] v = new int[]{0, 10, 20, 50, 100};
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]) dp[i][j] += dp[i][j - v[i]];
            }
        }
        System.out.println(dp[4][n]);
    }

    @Test
    public void dp2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] v = new int[]{0, 10, 20, 50, 100};
        for (int i = 1; i <= 4; i++) {
            for (int j = v[i]; j <= n; j++) {
                dp[j] += dp[j - v[i]];
            }
        }
        System.out.println(dp[n]);
    }
}
