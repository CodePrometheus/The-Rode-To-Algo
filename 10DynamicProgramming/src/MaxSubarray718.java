import org.junit.Test;

/**
 * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 11-13-2021 19:13
 */
public class MaxSubarray718 {

    public int findLength(int[] n1, int[] n2) {
        int res = 0, len1 = n1.length, len2 = n2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (n1[i - 1] == n2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    @Test
    public void findLengthTest() {
        int[] n1 = {1, 2, 3, 2, 1};
        int[] n2 = {3, 2, 1, 4, 7};
        findLength(n1, n2);
    }
}
