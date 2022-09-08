package com.star.array;

import org.junit.Test;

/**
 * @Author: zzStar
 * @Date: 12-04-2021 10:12
 */
public class LongestIncreasing300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n + 1];
        tail[0] = Integer.MIN_VALUE;
        int end = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > tail[end]) {
                end++;
                tail[end] = num;
                dp[i] = end;
            } else {
                int l = 1, r = end;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tail[mid] < num) l = mid + 1;
                    else r = mid;
                }
                tail[l] = num;
                dp[i] = l;
            }
        }
        int[] res = new int[end];
        int len = end;
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[len - 1] = nums[i];
                len--;
            }
        }
        return res.length;
    }

    @Test
    public void lengthOfLISTest() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("lengthOfLIS(nums) = " + lengthOfLIS(nums));
    }

}
