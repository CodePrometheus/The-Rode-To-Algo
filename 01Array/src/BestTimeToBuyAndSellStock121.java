import org.junit.Test;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 *
 * @Author: zzStar
 * @Date: 02-07-2021 23:17
 */
public class BestTimeToBuyAndSellStock121 {

    /**
     * 动态规划
     * 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        // 记录【今天之前买入的最小值】
        int min = prices[0], max = 0;
        // 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /**
     * 暴力  两个for循环
     * 时间复杂度：O(n^2)
     * 循环运行 {n (n-1)}/{2}
     * 空间复杂度：O(1)O(1)。只使用了常数个变量。
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        // i在前，j在后
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    /**
     * 一次循环
     * 用一个变量记录一个历史最低价格 min，我们就可以假设自己的股票是在那天买的。那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - min。
     */
    public int maxProfit3(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        // 遍历数组的时候，边更新最低点边求差值
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }


    @Test
    public void maxProfitTest() {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit2(nums));
        System.out.println(maxProfit3(nums));
    }
}
