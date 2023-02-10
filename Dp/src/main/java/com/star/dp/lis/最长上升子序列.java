package com.star.dp.lis;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">T300</a>
 *
 * @Author: zzStar
 * @Date: 03-26-2022 16:01
 */
public class 最长上升子序列 {

    /**
     * 只有一个数组，长度 n，求最长上升子序列，定义 f[i] 为以 arr[i] 为结尾的最长上升子序列
     * 状态转移是从 [1,…j - 1] 找后面可以接上 arr[i] 的数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[res - 1]) {
                dp[res++] = nums[i];
            } else {
                int l = 0, r = res - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (dp[mid] >= nums[i]) {
                        r--;
                    } else {
                        l++;
                    }
                }
                dp[r] = nums[i];
            }
        }
        System.out.println(res);
    }

}
