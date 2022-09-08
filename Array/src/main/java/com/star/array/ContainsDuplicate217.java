package com.star.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * @Author: zzStar
 * @Date: 02-09-2021 23:29
 */
public class ContainsDuplicate217 {

    /**
     * 利用set
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            // 如果数字已经存在于 set 中，直接返回 true
            if (hashSet.contains(num)) {
                return true;
            }
            hashSet.add(num);
        }
        // 如果成功遍历完数组，则表示没有重复元素，返回 false
        return false;
    }

    @Test
    public void containsDuplicateTest() {
        int[] num = {1, 2, 3, 2};
        System.out.println(containsDuplicate(num));
    }
}
