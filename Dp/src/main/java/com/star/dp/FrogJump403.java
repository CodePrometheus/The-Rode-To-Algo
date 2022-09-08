package com.star.dp;

import org.junit.Test;

/**
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * <p>
 * 给你石子的位置列表 stones（用单元格序号 升序 表示），请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * <p>
 * 开始时，青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * <p>
 * 如果青蛙上一步跳跃了k个单位，那么它接下来的跳跃距离只能选择为k - 1、k或k + 1 个单位。另请注意，青蛙只能向前方（终点的方向）跳跃。
 * 示例 1：
 * <p>
 * 输入：stones = [0,1,3,5,6,8,12,17]
 * 输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 * 示例 2：
 * <p>
 * 输入：stones = [0,1,2,3,4,8,9,11]
 * 输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 * 提示：
 * <p>
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 231 - 1
 * stones[0] == 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-29-2021 21:40
 */
public class FrogJump403 {

    /**
     * dp[i][k] i为第i个石子，k为从 上一个石子j 跳到i石子上的步数
     * 易知dp[0][0]=true
     * 转移方程：dp[i][k]=dp[j][k-1]||dp[j][k]||dp[j][k+1]
     * j为i的上一次石子，注意：j不一定等于i-1;
     * k=stones[i]-stones[j],即从j石子跳到i石子的步数
     * 因为j->i花费了k步，所以可以推算得知，从j的上一颗石子跳到j石子应该是用了k-1、k或者k+1步。
     * 这样进行计算，最后我们只需要查看dp[stones.length-1][]中有没有true，有的话就证明可以跳到终点。
     */
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = true;
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 得到从j跳到i的步数
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
                if (i == stones.length - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }


    @Test
    public void canCrossTest() {
        int[] nums = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(nums));
    }
}
