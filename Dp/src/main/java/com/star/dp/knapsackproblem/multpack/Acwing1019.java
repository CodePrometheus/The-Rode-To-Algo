package com.star.dp.knapsackproblem.multpack;

import java.util.Scanner;

/**
 * 为了庆贺班级在校运动会上取得全校第一名成绩，班主任决定开一场庆功会，为此拨款购买奖品犒劳运动员
 * 期望拨款金额能购买最大价值的奖品，可以补充他们的精力和体力
 * 输入格式
 * 第一行二个数n，m，其中n代表希望购买的奖品的种数，m表示拨款金额
 * <p>
 * 接下来n行，每行3个数，v、w、s，分别表示第I种奖品的价格、价值（价格与价值是不同的概念）
 * 和能购买的最大数量（买0件到s件均可）
 * <p>
 * 输出格式
 * 一行：一个数，表示此次购买能获得的最大的价值（注意！不是价格）
 * 5 1000
 * 80 20 4
 * 40 50 9
 * 30 50 7
 * 40 30 6
 * 20 20 1
 * ---
 * 1040
 *
 * @Author: Starry
 * @Date: 09-11-2022 22:06
 */
public class Acwing1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int v, s, w;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            v = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();
            for (int j = m; j >= v; j--) { // 花的钱数 从大到小
                for (int k = 0; k <= s && k * v <= j; k++) { // 个数 从少到多
                    dp[j] = Math.max(dp[j], dp[j - v * k] + k * w);
                }
            }
        }
        System.out.println(dp[m]);
    }
}
