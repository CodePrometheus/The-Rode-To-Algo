package com.star.dp.state;

import java.util.Scanner;

/**
 * 阿福是一名经验丰富的大盗。趁着月黑风高，阿福打算今晚洗劫一条街上的店铺。
 * <p>
 * 这条街上一共有 N 家店铺，每家店中都有一些现金。
 * <p>
 * 阿福事先调查得知，只有当他同时洗劫了两家相邻的店铺时，街上的报警系统才会启动，然后警察就会蜂拥而至。
 * <p>
 * 作为一向谨慎作案的大盗，阿福不愿意冒着被警察追捕的风险行窃。
 * <p>
 * 他想知道，在不惊动警察的情况下，他今晚最多可以得到多少现金？
 * <a href="https://leetcode.cn/problems/house-robber/">198</a>
 * 输入格式
 * 输入的第一行是一个整数 T，表示一共有 T 组数据。
 * 接下来的每组数据，第一行是一个整数 N ，表示一共有 N 家店铺。
 * 第二行是 N 个被空格分开的正整数，表示每一家店铺中的现金数量。
 * 每家店铺中的现金数量均不超过1000。
 * 输出格式
 * 对于每组数据，输出一行。
 * 该行包含一个整数，表示阿福在不惊动警察的情况下可以得到的现金数量
 * 2
 * 3
 * 1 8 2
 * 4
 * 10 7 6 14
 * ---
 * 8
 * 24
 *
 * @Author: Starry
 * @Date: 09-19-2022 22:51
 */
public class Acwing1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            if (n < 2) {
                System.out.println(a[0]);
                break;
            }
            int[] dp = new int[n];
            dp[0] = a[0];
            dp[1] = Math.max(dp[0], a[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 2] + a[i], dp[i - 1]);
            }
            System.out.println(dp[n - 1]);
        }
    }
}
