package com.star.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * @Author: zzStar
 * @Date: 03-06-2021 12:36
 */
public class NextGreaterElementII503 {

    /**
     * 思路  -> 对于「找最近一个比当前值大/小」的问题，都可以使用单调栈来解决。
     * 单调栈就是在栈的基础上维护一个栈内元素单调
     * 将当前还没得到答案的下标暂存于栈内，从而实现「被动」更新答案。
     * 栈内存放的永远是还没更新答案的下标
     * 1.将数组中所有元素全部置为-1
     * 2.遍历两次，相当于循环遍历
     * 3.第一遍遍历，入栈索引i
     * 4.只要后面元素比栈顶索引对应的元素大，索引出栈，更改res[sta.pop()]的数值
     * 5.最后栈里面剩余的索引对应的数组值，都为默认的-1（因为后面未找到比它大的值）
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.add(i);
            }
        }
        return res;
    }

    /**
     * 静态数组来模拟栈，代码将会更快一点
     */
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 使用数组模拟栈，hh 代表栈底，tt 代表栈顶
        int[] d = new int[n * 2];
        int hh = 0, tt = -1;
        for (int i = 0; i < n * 2; i++) {
            while (hh <= tt && nums[i % n] > nums[d[tt]]) {
                int u = d[tt--];
                ans[u] = nums[i % n];
            }
            d[++tt] = i % n;
        }
        return ans;
    }


    @Test
    public void nextGreaterElementsTest() {
        int[] num = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(num)));
        System.out.println(Arrays.toString(nextGreaterElements2(num)));
    }
}
