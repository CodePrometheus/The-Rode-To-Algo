package com.star.dp.knapsackproblem.zeroone;

import org.junit.Test;

import java.util.Scanner;

/**
 * 有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M
 * 每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi
 * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
 * 输出最大价值
 * 第一行三个整数，N,V,M，用空格隔开，分别表示物品件数、背包容积和背包可承受的最大重量。
 * 接下来有 N 行，每行三个整数 vi,mi,wi，用空格隔开，分别表示第 i 件物品的体积、重量和价值
 * 输出一个整数，表示最大价值
 * <a href="https://www.acwing.com/problem/content/8/">二维费用的背包问题</a>
 * ---
 * 4 5 6
 * 1 2 3
 * 2 4 4
 * 3 4 5
 * 4 5 6
 * ---
 * 8
 *
 * @Author: Starry
 * @Date: 09-11-2022 20:07
 */
public class Acwing8 {
    @Test
    public void dp1() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt(), M = sc.nextInt();
        int[] v = new int[N + 1], m = new int[N + 1], w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // 传统解法 对于n种约束需要构建一个n维的dp矩阵
        int[][][] dp = new int[N + 1][V + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= M; k++) {
                    dp[i][j][k] = dp[i - 1][j][k]; // 所有不包含物品i的选法

                    if (j >= v[i] && k >= m[i]) { // 原状态最大的体积和重量 + 现在的价值
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                dp[i - 1][j - v[i]][k - m[i]] + w[i]);
                    }
                }
            }
        }
        System.out.println(dp[N][V][M]);
    }

    @Test
    public void dp2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt(), M = sc.nextInt();
        int[] v = new int[N + 1], m = new int[N + 1], w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] dp = new int[V + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= 1; j--) {
                for (int k = M; k >= 1; k--) {
                    dp[j][k] = dp[j][k]; // 所有不包含物品i的选法
                    if (j >= v[i] && k >= m[i]) { // 原状态最大的体积和重量 + 现在的价值
                        dp[j][k] = Math.max(dp[j][k],
                                dp[j - v[i]][k - m[i]] + w[i]);
                    }
                }
            }
        }
        System.out.println(dp[V][M]);
    }
}
