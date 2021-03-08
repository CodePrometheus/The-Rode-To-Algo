import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 *
 * @Author: zzStar
 * @Date: 03-08-2021 08:47
 */
public class PalindromePartitioningII132 {

    /**
     * 如果从分割字符串的角度考虑这个问题的话，对于一个区间内的字符串来说，每一个位置都将是可能的分割点，
     * 可以用暴力递归的方式找出答案，但是时间复杂度太高，加上预处理回文数组能勉强通过。
     * 换个角度想想，当切割次数最少使得切割后的所有字符串都是回文时，
     * 也正是这些回文子串最长的时候，那么如果说能找到以每个字符为中心的最长回文串，实际上就已经找到了答案
     */
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int length = s.length();
        int[] dp = new int[length];
        Arrays.fill(dp, length - 1);

        for (int i = 0; i < length; i++) {
            // 注意偶数长度与奇数长度回文串的特点 奇数回文串以1个字符为中心
            minCutHelper(s, i, i, dp);
            // 偶数回文串以2个字符为中心
            minCutHelper(s, i, i + 1, dp);
        }
        return dp[length - 1];
    }

    private void minCutHelper(String s, int i, int j, int[] dp) {
        int length = s.length();
        while (i >= 0 && j < length && s.charAt(i) == s.charAt(j)) {
            // 如果以当前字符为中心的最大回文串左侧为i，右侧为j，那s[i]~s[j]长度是不需要切割的，只需要在s[i-1]处切一刀即可，即dp[i-1]+1
            // 不断往外扩散更新dp值取dp[-1]即可
            dp[j] = Math.min(dp[j], (i == 0 ? -1 : dp[i - 1]) + 1);
            i--;
            j++;
        }
    }


    @Test
    public void minCutTest() {
        String s = "abcd";
        System.out.println(minCut(s));
        for (int i = 0; i < 3; ++i) {
            System.out.println(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
    }
}
