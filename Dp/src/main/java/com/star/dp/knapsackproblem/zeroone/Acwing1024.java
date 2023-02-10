package com.star.dp.knapsackproblem.zeroone;

import org.junit.Test;

import java.util.Scanner;

/**
 * 箱子容量为V，同时有n个物品
 * 要求 n 个物品中，任取若干个装入箱内，使箱子的剩余空间为最小
 * 第一行是一个整数V，表示箱子容量
 * 第二行是一个整数n，表示物品数
 * 接下来n行，代表这n个物品的各自体积
 * 输出箱子的剩余空间
 * 24
 * 6
 * 8
 * 3
 * 12
 * 7
 * 9
 * 7
 * ---
 * 0
 *
 * @Author: Starry
 * @Date: 09-11-2022 16:59
 */
public class Acwing1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), v;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            for (int j = m; j >= v; j--) {
                dp[j] = Math.max(dp[j], dp[j - v] + v);
            }
        }
        // 最后总体积-最大的体积 求出背包体积剩余最少
        System.out.println(m - dp[m]);
    }

    // 直接定义 f[i][j]为前i个物品装到容量为J的背包中最小的剩余空间
    @Test
    public void dp2() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), v;
        int[] dp = new int[m + 1];
        for (int i = 1; i < m; i++) dp[i] = i;
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            for (int j = m; j >= v; j--) {
                dp[j] = Math.min(dp[j], dp[j - v]);
            }
        }
        System.out.println(dp[m]);
    }
}
