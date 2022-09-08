package com.star.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中，A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @Author: zzStar
 * @Date: 02-27-2021 20:33
 */
public class SortArrayByParity905 {

    /**
     * 显然的双指针
     * 左指针寻找奇数值，右指针寻找偶数值，当符合交换条件时，进行两数交换；
     * 否则指针继续左右运动，寻找符合条件的奇偶值。
     * 当两指针相遇时，结束循环。
     */
    public int[] sortArrayByParity(int[] a) {
        if (a == null || a.length == 1) {
            return a;
        }
        int l = 0;
        int r = a.length - 1;
        int tem;
        while (l < r) {
            // 左指针对应奇数值，右指针对应偶数值，进行交换
            if ((a[l] & 1) == 1 && (a[r] & 1) == 0) {
                tem = a[l];
                a[l] = a[r];
                a[r] = tem;
            } else if ((a[l] & 1) == 0) {
                // 左指针对应的是偶数值，符合题意，继续向右移动
                l++;
            } else if ((a[r] & 1) == 1) {
                // 右指针对应的是奇数值，符合题意，继续向左移动
                r--;
            }
        }
        return a;
    }

    @Test
    public void sortArrayByParityTest() {
        int[] a = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(a)));
    }
}
