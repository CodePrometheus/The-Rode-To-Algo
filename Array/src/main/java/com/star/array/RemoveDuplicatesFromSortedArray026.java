package com.star.array;

import org.junit.Test;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @Author: zzStar
 * @Date: 02-03-2021 20:43
 */
public class RemoveDuplicatesFromSortedArray026 {

    /**
     * 双指针解决
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;

        /**
         * 遇到 nums[j] != nums[i]时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i + 1],
         *  然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
         *
         */
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 数组是有序的，那么重复的元素一定会相邻。
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        // 不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        // 最后返回的是长度
        return p + 1;
    }

    @Test
    public void test() {
        int[] num = {1, 2, 2};
        System.out.println(removeDuplicates(num));
        System.out.println(removeDuplicates2(num));
    }
}
