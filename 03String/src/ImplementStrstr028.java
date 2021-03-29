import org.junit.Test;

/**
 * 实现strStr()函数。
 * <p>
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1
 *
 * @Author: zzStar
 * @Date: 02-15-2021 23:24
 */
public class ImplementStrstr028 {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int len = needle.length();
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == len - 1) {
                    return i - j;
                }
                j++;
            } else {
                i = i - j;
                j = 0;
                if (haystack.length() - i < len) {
                    return -1;
                }
            }
        }
        return -1;
    }

    /**
     * 暴力
     */
    public int strStr2(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();
        for (int start = 0; start < n - L + 1; start++) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }



    @Test
    public void strStrTest() {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
        System.out.println(strStr2(haystack, needle));
    }
}
