package com.star.plus;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 寻找一个无序数组的中位数
 *
 * @Author: zzStar
 * @Date: 07-24-2022
 */
public class FindNoSortedArrayMedianNum {
    public static void main(String[] args) {
        System.out.println(find(new int[]{7, 2, 4, 9, 1, 5, 0}));
    }

    class Solution {
        public int candy(int[] ratings) {
            //边界
            if (ratings == null || ratings.length == 0) return 0;
            if (ratings.length == 1) return 1;
            //左右规则数组
            int[] left = new int[ratings.length];
            int[] right = new int[ratings.length];
            //至少一个元素
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);
            //统计结果
            int count = 0;
            //左遍历，保证左规则，即当前元素大于左边元素，就分配+1
            for (int i = 0; i < ratings.length; i++) {
                if (i == 0) {
                    if (ratings[i] > ratings[ratings.length - 1]) left[i] = left[ratings.length - 1] + 1;
                } else {
                    if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
                }
            }
            //右遍历，保证右规则，即当前元素大于右边元素，就分配+1
            for (int i = ratings.length - 1; i >= 0; i--) {
                if (i == ratings.length - 1) {
                    if (ratings[i] > ratings[0]) right[i] = right[0] + 1;
                } else {
                    if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
                }
                //满足左右规则最大值，则为最少分配糖果数
                count += Math.max(left[i], right[i]);
            }
            return count;
        }
    }

    /**
     * 小顶堆，k=len/2+1，标是在最小堆里存数组中后k个数，则小顶堆顶就是中位数
     * 如果遇到比小顶堆堆顶大的数，就删除堆顶插入新的数，否则继续
     */
    static double find(int[] nums) {
        // 默认是小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = nums.length, k = len / 2 + 1;
        // 先向堆中插入前k个数
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        // 依次与后k个数作比较
        for (int i = k; i < len; i++) {
            if (queue.peek() < nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        if (len % 2 == 0) {
            return (queue.poll() + queue.peek()) / 2.0;
        } else {
            return queue.peek();
        }
    }
}
