package com.star.dp.knapsackproblem.multpack;

import org.junit.Test;

import java.util.Scanner;

/**
 * 有 N 组物品和一个容量是 V 的背包。
 * <p>
 * 每组物品有若干个，同一组内的物品最多只能选一个。
 * 每件物品的体积是 vij，价值是 wij，其中 i 是组号，j 是组内编号。
 * <p>
 * 求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。
 * <p>
 * 输出最大价值。
 * <p>
 * 输入格式
 * 第一行有两个整数 N，V，用空格隔开，分别表示物品组数和背包容量。
 * <p>
 * 接下来有 N 组数据：
 * <p>
 * 每组数据第一行有一个整数 Si，表示第 i 个物品组的物品数量；
 * 每组数据接下来有 Si 行，每行有两个整数 vij,wij，用空格隔开，分别表示第 i 个物品组的第 j 个物品的体积和价值；
 * 输出格式
 * 输出一个整数，表示最大价值。
 * 3 5
 * 2
 * 1 2
 * 2 4
 * 1
 * 3 4
 * 1
 * 4 5
 * ---
 * 8
 *
 * @Author: Starry
 * @Date: 09-12-2022 16:10
 */
public class Acwing9 {
    // 给定多组物品，每组里有若干物品，同一组内的物品最多只能选一个
    // 求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] s = new int[101];
        int[][] v = new int[101][101], w = new int[101][101];
        int[][] dp = new int[101][101];
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= v[i][k])
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i][k]] + w[i][k]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }

    @Test
    public void dp2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] s = new int[101];
        int[][] v = new int[101][101], w = new int[101][101];
        int[] dp = new int[101];
        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            for (int j = 1; j <= s[i]; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j >= v[i][k])
                        dp[j] = Math.max(dp[j], dp[j - v[i][k]] + w[i][k]);
                }
            }
        }
        System.out.println(dp[m]);
    }
}
