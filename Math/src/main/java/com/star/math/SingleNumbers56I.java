package com.star.math;

import org.junit.Test;

import java.util.Arrays;

/**
 * v一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 05-19-2021 22:58
 */
public class SingleNumbers56I {

    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        int xor = 0;
        /** 得到A^B的结果
         基于异或运算的以下几个性质
         1. 交换律
         2. 结合律
         3. 对于任何数x，都有x^x=0，x^0=x
         */
        for (int num : nums) {
            xor ^= num;
        }
        // x & (-x)本身的作用是得到最低位的1
        // 而我们所需要的做到的是：利用这个1来进行分组，也就是做到将A和B区分开
        // 前面已经知道，x是我们需要的结果数A和B相异或的结果，也就是说，x的二进制串上的任何一个1，都能成为区分A和B的条件
        // 因此我们只需要得到x上的任意一个1，就可以做到将A和B区分开来
        int lowBit = (-xor) & xor;
        for (int num : nums) {
            if ((num & lowBit) == 0) {
                ans[0] ^= num;
            }
        }
        ans[1] = xor ^ ans[0];
        return ans;
    }

    @Test
    public void singleNumbersTest() {
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
