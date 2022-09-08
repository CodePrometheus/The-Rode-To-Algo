package com.star.array;

import org.junit.Test;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * cost的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为[0, 999] 。
 *
 * @Author: zzStar
 * @Date: 02-25-2021 22:52
 */
public class MinCostClimbingStairs746 {

    /**
     * 动态规划
     * dp[i] 表示达到下标 i 的最小花费。
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 可以选择下标 00 或 11 作为初始阶梯
        dp[0] = dp[1] = 0;
        //  2 <= i <= n时，可以从下标 i−1 使用cost[i−1] 的花费达到下标 i，
        //  或者从下标 i−2 使用 cost[i−2] 的花费达到下标 i。为了使总花费最小，dp[i] 应取上述两项的最小值
        /**
         * 踏上第i级台阶有两种方法：
         *
         * 先踏上第i-2级台阶（最小总花费dp[i-2]），再直接迈两步踏上第i级台阶（花费cost[i]），最小总花费dp[i-2] + cost[i]；
         *
         * 先踏上第i-1级台阶（最小总花费dp[i-1]），再迈一步踏上第i级台阶（花费cost[i]），最小总花费dp[i-1] + cost[i]；
         */
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    /**
     * 注意到当 i≥2 时，dp[i] 只和 dp[i−1] 与 dp[i−2] 有关，
     * 因此可以使用滚动数组的思想，将空间复杂度优化到 O(1)。
     */
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    @Test
    public void minCostClimbingStairsTest() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
