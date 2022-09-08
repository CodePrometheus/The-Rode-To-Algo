package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 * @Author: zzStar
 * @Date: 02-28-2021 12:28
 */
public class SortArrayByParityII922 {

    /**
     * 在原始数组上进行修改
     */
    public int[] sortArrayByParityII(int[] nums) {
        // 记录奇数下标
        int j = 1;
        // 只遍历偶数下标的元素
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            // 遍历出来的的偶数下标元素不是偶数
            if ((nums[i] & 1) != 0) {
                // 则去判断奇数下标j的元素是否为奇数
                while ((nums[j] & 1) != 0) {
                    // 若是奇数则+2直到找到一个元素为偶数的奇数下标
                    j = j + 2;
                }
                int tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
            }
        }
        return nums;
    }

    /**
     * 两次遍历
     */
    public int[] sortArrayByParityII2(int[] nums) {
        int i = 0, j = 1;
        int[] res = new int[nums.length];
        for (int a : nums) {
            if ((a & 1) == 0) {
                res[i] = a;
                i += 2;
            } else {
                res[j] = a;
                j += 2;
            }
        }
        return res;
    }

    @Test
    public void sortArrayByParityIITest() {
        int[] a = {2, 4, 3, 1};
        System.out.println(Arrays.toString(sortArrayByParityII(a)));
        System.out.println(Arrays.toString(sortArrayByParityII2(a)));
    }
}
