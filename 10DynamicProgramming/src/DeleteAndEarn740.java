import org.junit.Test;

/**
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 05-05-2021 22:02
 */
public class DeleteAndEarn740 {

    /**
     * 转换为打家劫舍问题
     */
    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int num : nums) {
            trans[num] += num;
        }

        int[] dp = new int[10001];

        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + trans[i]);
        }

        return dp[dp.length - 1];
    }

    @Test
    public void deleteAndEarnTest() {
        int[] nums = {2, 2, 3, 3, 3, 4};
        System.out.println(deleteAndEarn(nums));
    }
}
