import org.junit.Test;

/**
 * 定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * <p>
 * 示例 1:
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * @Author: zzStar
 * @Date: 12-03-2021 20:36
 */
public class LongestSubstring340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length(), l = 0, r = 0, cnt = 0;
        int[] map = new int[128];
        while (r < len) {
            // 新字符串
            if (map[s.charAt(r++)]++ == 0) {
                cnt++;
            }
            // 如果不同字符个数超过要求，就删除左指针字符
            if (cnt > k) {
                if (--map[s.charAt(l++)] == 0) {
                    cnt--;
                }
            }
        }
        return r - l;
    }


    @Test
    public void lengthOfLongestSubstringKDistinctTest() {
        String s = "eceba";
        int k = 2;
        int res = lengthOfLongestSubstringKDistinct(s, k);
        System.out.println("res = " + res);
    }
}
