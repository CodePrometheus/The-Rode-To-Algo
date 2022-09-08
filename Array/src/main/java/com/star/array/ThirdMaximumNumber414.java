package com.star.array;

import org.junit.Test;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * @Author: zzStar
 * @Date: 02-11-2021 23:50
 */
public class ThirdMaximumNumber414 {

    /**
     * 非空数组，所以长度大于0的
     * 每次更新第一大值和第二大值时，都传递给第三大值
     * 注意重复的跳过，最后判断第三大有没有更新过
     */
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for (int num : nums) {
            // 过滤重复和小于第三大的数
            if (third >= num || second == num || first == num) continue;
            if (first < num) {
                third = second;
                second = first;
                first = num;
            } else if (second < num) {
                third = second;
                second = num;
            } else {
                third = num;
            }
        }
        return (int) (third == Long.MIN_VALUE ? first : third);
    }

    @Test
    public void thirdMaxTest() {
        int[] nums = {1, 2, -2147483648};
        System.out.println(thirdMax(nums));
    }

}
