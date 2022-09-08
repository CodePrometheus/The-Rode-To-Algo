package com.star.array;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-02-2021 23:19
 */
public class VolumeOfHistogramLcci042 {

    /**
     * 只要右边有比左边高的柱子，无论中间是什么情况。当前能存的雨水量只和左边的柱子相关。
     * 因此 ans +=max(0,left_max-height[left]);
     * 同理，如果左边比右边的柱子高，无论中间是什么情况，当前能存的水量为 ans +=max(0,right_max-height[right]);
     * <p>
     * 左右两个指针更新左边最高和右边最高，直到相交
     */
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int res = 0;

        while (l <= r) {
            // 两种情乱
            if (maxL < maxR) {
                // 右边的高
                res += Math.max(0, maxL - height[l]);
                // 更新
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                // 相反的话
                res += Math.max(0, maxR - height[r]);
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }
        return res;
    }

    /**
     * 只有凹的地方能存水，存水量遵循短板原则，所以用每个位置左右两侧最大值中的较小者减当前位置的值即可得到当前位置储水量。
     * <p>
     * 解题方法：先倒叙遍历，用数组记录每个位置其右侧最大值max右，再正序遍历，时刻记录并更新当前位置左侧的最大值max左，
     * 然后当前位置存水量c=Min(max左，max右)-当前值，如果c<=0则表示没有水，抛弃即可，最后每个位置的c累加一起的和即为总储水量。
     */
    public int trap2(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int length = height.length;
        int[] maxR = new int[length];
        int[] maxL = new int[length];
        int water = 0;
        int max = height[length - 1];
        for (int i = length - 1; i >= 0; --i) {
            max = Math.max(max, height[i]);
            maxR[i] = max;
        }
        max = height[0];
        for (int i = 0; i < length; ++i) {
            max = Math.max(max, height[i]);
            maxL[i] = max;
        }
        for (int i = 0; i < length; ++i) {
            water += Math.min(maxR[i], maxL[i]) - height[i];
        }
        return water;
    }

    /**
     * 单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组 height 中的元素递减。
     * <p>
     * 从左到右遍历数组，遍历到下标 ii 时，如果栈内至少有两个元素，记栈顶元素为 top，top 的下面一个元素是 left，则一定有 height[left]≥height[top]。
     * 如果 height[i]>height[top]，则得到一个可以接雨水的区域，该区域的宽度是 i--1i−left−1，高度是 min(height[left],height[i])−height[top]，根据宽度和高度即可计算得到该区域能接的水的量。
     * <p>
     * 为了得到 left，需要将 top 出栈。在对 top 计算能接的水的量之后，left 变成新的 top，重复上述操作，直到栈变为空，或者栈顶下标对应的 height 中的元素大于或等于 height[i]。
     * <p>
     * 在对下标 i 处计算能接的水的量之后，将 i 入栈，继续遍历后面的下标，计算能接的水的量。遍历结束之后即可得到能接的水的总量。
     */
    public int trap3(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void trapTest() {
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(nums));
        System.out.println(trap2(nums));
        System.out.println(trap3(nums));
    }
}

