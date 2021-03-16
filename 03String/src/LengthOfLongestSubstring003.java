import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-11-2021 21:55
 */
public class LengthOfLongestSubstring003 {

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        // 窗口开始位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            /**
             * last[ascii_value]+1，last[ascii_value]记录着上一次重复字母的索引位置，
             * 每次重复了，窗口的开始端就要滑动一位,也就是+1。比如：abcad，第一个最大窗口是[abc]，此时last[97]=0
             *  然后a重复了，于是窗口开始端就要滑动到last[97]+1位置，就把第一个a排除了，此时的最大窗口就是[bcad]。
             */
            start = Math.max(start, last[index] + 1);
            /**
             * "i-start+1"就是通过索引计算字符长度：大索引-小索引+1
             * start就是窗口开始端 i就是窗口结束端（窗口内字母个数=窗口结束端-窗口开始端+1）
             */
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    /**
     * hashmap
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            // 出现重复，则更新开始位置
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    /**
     * 用set维护一个不重复的窗口
     */
    public int lengthOfLongestSubstring3(String s) {
        int ret = 0;
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (set.contains(c)) {
                // 包含就把左边移除，同时维护左边界
                set.remove(s.charAt(l++));
            }
            // 不包含就加进去
            set.add(c);
            // 维护最长的不重复子序列，也就是与之前的窗口大小进行比较，
            ret = Math.max(ret, r - l + 1);
        }
        return ret;
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring4(String s) {
        // if(s==null) return 0;这句话可以不加，s.length()长度为0时，不进入下面的循环，会直接返回max=0;
        // 划定当前窗口的坐标为(start,i],左开右闭,所以start的初始值为-1，而非0。
        int max = 0, start = -1;
        // 使用哈希表map统计各字符最后一次出现的索引位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            // 当字符在map中已经存储时，需要判断其索引值index和当前窗口start的大小以确定是否需要对start进行更新:
            // 当index>start时，start更新为当前的index,否则保持不变。
            // 注意若index作为新的start，计算当前滑动空间的长度时也是不计入的，左开右闭，右侧s[i]会计入，这样也是防止字符的重复计入。
            if (map.containsKey(tmp)) {
                start = Math.max(start, map.get(tmp));
            }

            // 如果map中不含tmp，此处是在map中新增一个键值对，否则是对原有的键值对进行更新
            map.put(tmp, i);

            //i-start,为当前滑动空间(start,i]的长度，若其大于max，则需要进行更新。
            max = Math.max(max, i - start);
        }
        return max;
    }


    @Test
    public void lengthOfLongestSubstringTest() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
        System.out.println(lengthOfLongestSubstring3(s));
        System.out.println(lengthOfLongestSubstring4(s));
    }
}
