import org.junit.Test;

/**
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
                // sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
                sum = num;
            }
            // 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
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

    @Test
    public void maxSubArrayTest() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

}
