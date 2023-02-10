package com.star.dp.lis;

import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/description/274/
 *
 * @Author: zzStar
 * @Date: 03-26-2022 16:31
 */
public class 最长公共上升子序列 {

    /**
     * 第一行包含一个整数 N，表示数列 A，B 的长度
     * 子序列默认不要求连续
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        // 只考虑 a 数组的前 i 个和 b 数组的前 j 个，且以 b[j] 结尾的选法集合
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                // a[i] 不在最长公共上升子序列
                dp[i][j] = dp[i - 1][j];
                // 此时 a[i] 能加入以 b[j] 结尾的序列
                if (a[i] == b[j]) {
                    dp[i][j] = Math.max(dp[i][j], max + 1);
                } else if (b[j] < a[i]) {
                    max = Math.max(max, dp[i - 1][j]);
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }

}
