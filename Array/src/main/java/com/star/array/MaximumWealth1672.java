package com.star.array;

import org.junit.Test;

/**
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * <p>
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 * 示例 2：
 * <p>
 * 输入：accounts = [[1,5],[7,3],[3,5]]
 * 输出：10
 * 解释：
 * 第 1 位客户的资产总量 = 6
 * 第 2 位客户的资产总量 = 10
 * 第 3 位客户的资产总量 = 8
 * 第 2 位客户是最富有的，资产总量是 10
 * 示例 3：
 * <p>
 * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出：17
 *
 * <p>
 * 提示：
 * <p>
 * m ==accounts.length
 * n ==accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/richest-customer-wealth
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-09-2021 23:23
 */
public class MaximumWealth1672 {

    /**
     * 定义一个最大值结果变量来盛放最大值结果；
     * 遍历二维数组里面每一个子数组，计算每一个子数组的和；
     * 用一个变量盛放子数组的和，该变量在每次计算新的子数组总和时需要归零；
     * 把每次计算出的子数组的和与最大值结果变量进行比较，选择更大的值，赋值给最大值结果变量；
     * 循环结束时，返回结果。
     */
    public int maximumWealth(int[][] accounts) {
        int i = accounts.length;
        // 模板
        int j = accounts[0].length;
        int max = 0;

        for (int n = 0; n < i; n++) {
            int sum = 0;
            for (int m = 0; m < j; m++) {
                sum = sum + accounts[n][m];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    @Test
    public void maximumWealthTest() {
        int[][] num = {{1, 2}, {3, 4}};
        System.out.println(maximumWealth(num));
    }

}
