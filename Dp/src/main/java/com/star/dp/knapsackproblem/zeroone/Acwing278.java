package com.star.dp.knapsackproblem.zeroone;

import java.util.Scanner;

/**
 * <a href="https://www.acwing.com/problem/content/280/">
 * 问装满背包有几种方法
 * </a>
 * 给定 N 个正整数 A1,A2,…,AN，从中选出若干个数，使它们的和为 M，求有多少种选择方案。
 * <p>
 * 输入格式
 * 第一行包含两个整数 N 和 M。
 * <p>
 * 第二行包含 N 个整数，表示 A1,A2,…,AN。
 * <p>
 * 输出格式
 * 包含一个整数，表示可选方案数。
 * 4 4
 * 1 1 2 2
 * ---
 * 3
 *
 * @Author: Starry
 * @Date: 09-11-2022 21:19
 */
public class Acwing278 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n], dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = m; j >= a[i]; j--) {
                dp[j] += dp[j - a[i]];
            }
        }
        System.out.println(dp[m]);
    }
}
