import org.junit.Test;

/**
 * 圆环上有 k 个点，编号为 0~9。从 0 点出发，每次可以逆时针和顺时针走 1 步，问走 n 步回到 0 点共有多少种走法
 * <p>
 * 输入: 2
 * 输出: 2
 * 解释：有2种方案。分别是0->1->0和0->9->0
 *
 * @Author: zzStar
 * @Date: 04-18-2022 15:00
 */
public class ZeroCycle {

    /**
     * 圆环中有 k 个节点，走 n 步 回到原点有几种走法
     * 走 n 步到 0 的方案数 = 走 n - 1 步到 1 的方案数 + 走 n - 1 步到 9 的方案数
     * dp[i][j] 表示从 0 出发，走 i 步到 j 的方案数
     */
    int zeroCycle(int k, int n) {
        int[][] dp = new int[n + 1][k];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                // 取余是因为j-1或j+1可能会超过圆环0~9的范围
                dp[i][j] = dp[i - 1][(j - 1 + k) % k] + dp[i - 1][(j + 1) % k];
            }
        }
        return dp[n][0];
    }

    @Test
    public void test() {
        System.out.println(zeroCycle(10, 2));
    }

}
