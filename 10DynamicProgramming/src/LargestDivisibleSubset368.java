import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-30-2021 22:41
 */
public class LargestDivisibleSubset368 {

    /**
     * dp[i]为数组前i个元素构成的最大整除子集的个数
     * 也就是说，形同最长上升子序列
     * 特殊在于，返回的是最大整除子集的集合
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);
        int res = 1;
        // 记录最大整除子集中最后一个元素的位置
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    // 说明nums[i]可以放到nums[j]后面构成一个更长的整除子集,
                    // 也就是[……，……，……，nums[j]，nums[i]]。注意dp[i]记录
                    // 的整除子集中，nums[i]一定是数组的最后一个元素，我们用pre[i]记录这个子集中nums[i]的前一个元素的位置，也就是nums[j]的位置
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            // 如果找到更大的子集，就记录最大的即可
            if (dp[i] > res) {
                res = dp[i];
                idx = i;
            }
        }
        // 把找到的最大整除子集加入到list中，pre类似于链表，每一个都是记录前一个的位置
        List<Integer> list = new ArrayList<>();
        while (idx != -1) {
            list.add(nums[idx]);
            idx = pre[idx];
        }
        return list;
    }
}
