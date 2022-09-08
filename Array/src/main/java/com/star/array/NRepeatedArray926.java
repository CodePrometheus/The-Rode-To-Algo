package com.star.array;

import org.junit.Test;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 *
 * @Author: zzStar
 * @Date: 03-03-2021 20:35
 */
public class NRepeatedArray926 {

    /**
     * 抽屉原理
     */
    public int repeatedNTimes(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            if (arr[i] == arr[i + 1] || arr[i] == arr[i + 2]) {
                return arr[i];
            }
        }
        // 上面循环没找到，那必然是最后两个数是相等的，如[1,2,3,1]
        return arr[len - 1];
    }

    @Test
    public void repeatedNTimesTest() {
        int[] a = {1, 2, 3, 3};
        System.out.println(repeatedNTimes(a));
    }
}
