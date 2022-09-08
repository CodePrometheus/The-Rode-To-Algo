package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 * <p>
 * 返回该 最大总和
 *
 * @Author: zzStar
 * @Date: 02-12-2021 23:14
 */
public class ArrayPartitionI561 {

    /**
     * 从a1到an数组下标为奇数的数都加起来
     * 时间复杂度 O(nlog(n))。排序需要 O(nlog(n)) 的时间。另外会有一次数组的遍历。
     * <p>
     * 空间复杂度：O(1)。仅仅需要常数级的空间.
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    @Test
    public void arrayPairSumTest() {
        int[] nums = {6, 2, 6, 5, 1, 2};
        System.out.println(arrayPairSum(nums));
    }
}
