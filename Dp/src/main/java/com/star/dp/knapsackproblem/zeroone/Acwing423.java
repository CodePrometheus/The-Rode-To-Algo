package com.star.dp.knapsackproblem.zeroone;

import java.util.Scanner;

/**
 * 这个山洞里有一些不同的草药，采每一株都需要一些时间，每一株也有它自身的价值。我会给你一段时间，在这段时间里，你可以采到一些草药。如果你是一个聪明的孩子，你应该可以让采到的草药的总价值最大
 * <a href="https://www.acwing.com/problem/content/425/">425</a>
 * 输入文件的第一行有两个整数 T 和 M，用一个空格隔开，T 代表总共能够用来采药的时间，M 代表山洞里的草药的数目
 * 接下来的 M 行每行包括两个在 1 到 100 之间（包括 1 和 100）的整数，分别表示采摘某株草药的时间和这株草药的价值
 * 70 3
 * 71 100
 * 69 1
 * 1 2
 * ---
 * 3
 * 问能否能装满背包（或者最多装多少）
 *
 * @Author: Starry
 * @Date: 09-11-2022 15:55
 */
public class Acwing423 {
    // 一维优化
    // f[i][j]=max(f[i-1][j],f[i-1][j-W[i]]+V[i])(j>=W[i])
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), M = sc.nextInt();
        int[] dp = new int[T + 1];
        int[] w = new int[M + 1], v = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            for (int j = T; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        System.out.println(dp[T]);
    }

    // 二维
    void dp2() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), M = sc.nextInt();
        int[][] dp = new int[T + 1][T + 1];
        int[] w = new int[M + 1], v = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j <= T; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[M][T]);
    }
}
