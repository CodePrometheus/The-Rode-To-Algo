package com.star.array;

import org.junit.Test;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * @Author: zzStar
 * @Date: 02-10-2021 23:22
 */
public class MissingNumber268 {

    public static int missingNumber(int[] nums) {
        // 求长度为n的自然数和
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            // 减去已有的数，剩下的就是少的
            sum -= nums[i];
        }
        return sum;
    }

    /**
     * 由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，因此我们可以通过异或运算找到缺失的数字。
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }


    @Test
    public void missingNumberTest() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
    }
}
