import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * <p>
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * <p>
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * <p>
 * 注意：不允许旋转信封。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 示例 2：
 * <p>
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= envelopes.length <= 5000
 * envelopes[i].length == 2
 * 1 <= wi, hi <= 104
 *
 * @Author: zzStar
 * @Date: 03-04-2021 18:38
 */
public class RussianDollEnvelopes354 {

    /**
     * 按照宽度递增，高度递减排序。宽度递减可以保证最终结果每个宽度的信封只取一个。
     * 之后使用动态规划+二分查找的方法获取高度的最长递增子序列，其长度即为最终结果
     * 只要把排序规则改一下，把高更大的放前面，就可以成为只比较高的序列，从而成为一般的最长子序列问题，
     * 可以用二分更新序列的方法将复杂度降低为O(nlogn)
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        // 对envelopes按宽度递增，高度递减排序
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 获取高度序列
        int len = envelopes.length;
        int[] height = new int[len];
        for (int i = 0; i < len; i++) {
            height[i] = envelopes[i][1];
        }

        // 动态规划+二分查找
        int[] dp = new int[len + 1];
        int maxLen = 1;
        dp[maxLen] = height[0];
        for (int i = 0; i < len; i++) {

            // 当前位置的值大于dp中最后位置（maxLen位置）的值，则直接在后面插入
            if (height[i] > dp[maxLen]) {
                dp[++maxLen] = height[i];
            }
            // 否则对dp中已存在的值进行替换
            else {
                // 使用二分查找查找当前位置的值在dp中的插入位置，并对该位置的值进行替换
                // 由于对于相同宽度的信封，其高度总是递减的，因此对于相同宽度的信封，总会是高度小的替换高度大的
                // 且不会存在相同宽度信封共存的情况
                // 又因为是从dp[1]开始存储信封，因此，最终maxLen的值即为最大信封数
                int index = Arrays.binarySearch(dp, 0, maxLen + 1, height[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                dp[index] = height[i];
            }
        }
        return maxLen;
    }
}
