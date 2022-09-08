package com.star.array;

import org.junit.Test;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 02-04-2021 21:52
 */
public class MaximumSubarray053 {

    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        // 首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
        int ans = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                // sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
                sum += num;
            } else {
                // sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字num
                sum = num;
            }
            // 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果 更新ans
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * 联机算法
     */
    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // sum<0 则sum直接更新不增反减，将sum归零再更新
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            // 取序列和最大值
            max = (max < sum) ? sum : max;
        }
        return max;
    }

    /**
     * 滚动数组
     * f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            // 之前的加上当前所遍历的数 再与当前的数进行比较，当前的比之前的和要大，自然更新为当前的数
            int tmp = pre + x;
            pre = Math.max(tmp, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    @Test
    public void maxSubArrayTest() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));
    }

}
