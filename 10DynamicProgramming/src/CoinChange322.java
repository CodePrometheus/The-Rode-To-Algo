import org.junit.Test;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *
 * <p>
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-16-2021 16:42
 */
public class CoinChange322 {

    /**
     * 暴力递归解法
     */
    public int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subPro = coinChange(coins, amount - coin);
            // 子问题无解则跳过
            if (subPro == -1) {
                continue;
            }
            // 在子问题选择最优解，不断加1
            res = Math.min(res, subPro + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 动态规划
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int tmp = dp[i - coins[j]] + 1;
                    dp[i] = Math.min(tmp, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    @Test
    public void coinChange() {
        int[] nums = {1, 2, 5};
        int tar = 11;
        System.out.println(coinChange(nums, tar));
        System.out.println(coinChange2(nums, tar));
    }
}
