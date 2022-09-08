package com.star.array;

import org.junit.Test;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *
 * @Author: zzStar
 * @Date: 02-23-2021 12:54
 */
public class LongestContinuousIncreasingSubsequence674 {

    /**
     * 动态规划
     */
    public int findLengthOfLCIS(int[] nums) {
        // 当前值 连续递增序列的开始下标
        int d = 0;
        // 最长值
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // 前一个比后一个大
            if (nums[i] > nums[i - 1]) {
                max = Math.max(i - d + 1, max);
            } else {
                d = i;
            }
        }
        return max;
    }

    /**
     * 区间
     */
    public int findLengthOfLCIS2(int[] nums) {
        int l = 0;
        int r = 0;
        int res = 1;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        while (l < n && r < n) {
            int i = l + 1;
            while (i < n && nums[i] > nums[i - 1]) {
                i++;
            }
            r = i;
            res = Math.max(res, r - l);
            l = i;
        }
        return res;
    }

    @Test
    public void findLengthOfLCISTest() {
        int[] nums = {1, 2, 4, 3, 5};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS2(nums));
    }
}
