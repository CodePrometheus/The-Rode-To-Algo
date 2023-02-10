package com.star.dp.knapsackproblem.zeroone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 * <p>
 * 第 i 件物品的体积是 vi，价值是 wi。
 * <p>
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * <p>
 * 输出 字典序最小的方案。这里的字典序是指：所选物品的编号所构成的序列。物品的编号范围是 1…N。
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 * <p>
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 * <p>
 * 输出格式
 * 输出一行，包含若干个用空格隔开的整数，表示最优解中所选物品的编号序列，且该编号序列的字典序最小。
 * <p>
 * 物品编号范围是 1…N
 * ---
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 6
 * ---
 * 1 4
 *
 * @Author: Starry
 * @Date: 09-12-2022 15:30
 */
public class Acwing6 {
    // f[i, j] = max(f[i-1, j], f[i-1, j-v[i]]+w[i])
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt();
        int[][] dp = new int[1010][1010];
        int[] v = new int[N + 1], w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // 需要求字典序最小，dp求解从后往前求
        for (int i = N; i >= 1; i--) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i + 1][j]; // 不选
                if (j >= v[i])
                    dp[i][j] =
                            Math.max(dp[i][j], dp[i + 1][j - v[i]] + w[i]); // 选
            }
        }
        List<Integer> res = new ArrayList<>();
        int cur = V; // 当前最大体积
        for (int i = 1; i <= N; i++) {
            // 字典序最小，从小到大遍历，能选则选
            if (cur >= v[i] && dp[i][cur] == dp[i + 1][cur - v[i]] + w[i]) {
                res.add(i);
                cur -= v[i];
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
