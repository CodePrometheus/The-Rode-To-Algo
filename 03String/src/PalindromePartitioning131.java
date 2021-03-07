import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入:"aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 *
 * @Author: zzStar
 * @Date: 03-07-2021 11:05
 */
public class PalindromePartitioning131 {

    /**
     * dp[i][j] == true：表示从 i 到 j 的字符串是回文串。
     * <p>
     * 举个稍微长一点的例子吧，比如 aabcc：
     * <p>
     * (1) 单独一个字符是回文串：a|abcc，a 是一个回文串；
     * <p>
     * (2) 然后分析 abcc，单独切一个 a 是回文串：a|bcc，(ab，abc 和 abcc 都不是回文串就不考虑这三种切法了)，因此对于 abcc 就 a|bcc 这一种；
     * <p>
     * (3) 再分析 bcc，单独一个 b 是回文串：b|cc，(bc，bcc 也不是回文串)，因此对于 bcc 就 b|cc 这一种；
     * <p>
     * (4) 最后分析 cc，单独一个 c 是回文串：c|c，或者两个 c 也构成了回文串：cc|。c|c 中，后面这个 c，再切它就是 c|，所以现在就和 cc| 一样分到底了，因为 "|" 后面是空的。
     * 整理一下，【a, a，b，c，c】和【a, a，b，cc】是这次的结果，但还没有结束！
     * <p>
     * 因为是从 a 后面开始分割的，接下来可以从 aa|bcc，aab|cc，aabc|c，aabcc| 的角度来切，每次切完固定 "|" 前面的部分，用同样的切法分析 "|" 后面的部分。
     * <p>
     * 每次都从头开始遍历，一个字符两个字符三个字符这样检查，如果是一段回文串那就切开，切点后面的部分用同样的方法；如果切点后是空了就返回一个空 list(空字符串不是回文串)，在返回的不同路线上把 "|" 前面已经切好的部分加在这个 list 的前面，一直返回到路线的最开始就是结果了。
     * <p>
     * 采用分治的想法，把大字符串切成小字符串，小字符串切到空。
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        dfs(res, dp, 0, n, s, new ArrayList<String>());
        return res;

    }

    private void dfs(List<List<String>> res, boolean[][] dp, int i, int n, String s, ArrayList<String> tmp) {
        if (i == n) {
            res.add(new ArrayList<>(tmp));
        }
        for (int j = i; j < n; j++) {
            if (dp[i][j]) {
                tmp.add(s.substring(i, j + 1));
                dfs(res, dp, j + 1, n, s, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    @Test
    public void partitionTest() {
        String s = "aab";
        System.out.println(partition(s));
    }


}
